package roomescape.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import roomescape.dao.ReservationDao;
import roomescape.domain.Reservation;
import roomescape.dto.request.ReservationSaveRequest;
import roomescape.dto.response.ReservationResponse;
import roomescape.exception.ErrorCode;
import roomescape.exception.custom.ReservationException;

@Service
public class ReservationService {

    private final ReservationDao reservationDao;

    public ReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public ReservationResponse save(ReservationSaveRequest request) {
        Reservation requestReservation = request.toReservation();
        Reservation savedReservation = reservationDao.save(requestReservation);

        return new ReservationResponse(savedReservation);
    }

    public List<ReservationResponse> findAll() {
        return reservationDao.findAll().stream()
                .map(ReservationResponse::new)
                .toList();
    }

    public void delete(long id) {
        reservationDao.delete(id);
    }
}
