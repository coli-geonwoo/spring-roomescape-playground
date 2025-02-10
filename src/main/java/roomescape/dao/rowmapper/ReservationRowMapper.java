package roomescape.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import roomescape.domain.Reservation;
import roomescape.exception.ErrorCode;
import roomescape.exception.custom.ReservationException;

@Component
public class ReservationRowMapper implements RowMapper<Reservation> {

    @Override
    public Reservation mapRow(ResultSet rs, int rowNum) {
        try {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            LocalDate date = rs.getObject("date", LocalDate.class);
            LocalTime time = rs.getObject("time", LocalTime.class);
            return new Reservation(id, name, date, time);
        }catch(SQLException exception){
            throw new ReservationException(ErrorCode.DATA_ACCESS_EXCEPTION);
        }
    }
}
