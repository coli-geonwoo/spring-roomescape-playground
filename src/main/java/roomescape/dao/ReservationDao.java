package roomescape.dao;

import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import roomescape.dao.rowmapper.ReservationRowMapper;
import roomescape.domain.Reservation;

@Component
public class ReservationDao {

    private JdbcTemplate jdbcTemplate;
    private ReservationRowMapper reservationRowMapper;

    public ReservationDao(JdbcTemplate jdbcTemplate, ReservationRowMapper reservationRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.reservationRowMapper = reservationRowMapper;
    }

    public Reservation save(Reservation reservation) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into reservation(name, date, time) values (?, ?, ?)";
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(
                            sql,
                            new String[] {"id"});
                    ps.setString(1, reservation.getName());
                    ps.setString(2, reservation.getDate().toString());
                    ps.setString(3, reservation.getTime().toString());
                    return ps;
                    }, keyHolder);

        return new Reservation(
                keyHolder.getKey().longValue(),
                reservation.getName(),
                reservation.getDate(),
                reservation.getTime()
        );
    }

    public List<Reservation> findAll() {
        String sql = "select * from reservation";
        return jdbcTemplate.query(sql, reservationRowMapper);
    }

    public int delete(long id) {
        return jdbcTemplate.update("delete from reservation where id = ?", id);
    }
}
