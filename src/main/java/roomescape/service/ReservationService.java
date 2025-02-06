package roomescape.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import roomescape.domain.Reservation;
import roomescape.dto.request.ReservationSaveRequest;
import roomescape.dto.response.ReservationResponse;
import roomescape.exception.ErrorCode;
import roomescape.exception.custom.ReservationException;

@Service
public class ReservationService {

    private final AtomicLong counter = new AtomicLong();
    private final List<Reservation> reservations;


    public ReservationService() {
        this.reservations = new ArrayList<>();
    }

    public ReservationResponse save(ReservationSaveRequest request) {
        Reservation savedReservation = request.toReservation(counter.incrementAndGet());
        reservations.add(savedReservation);
        return new ReservationResponse(savedReservation);
    }

    public List<ReservationResponse> findAll() {
        return reservations.stream()
                .map(ReservationResponse::new)
                .toList();
    }

    public void delete(long id) {
        Optional<Reservation> targetReservation = reservations.stream()
                .filter(reservation -> reservation.getId() == id)
                .findAny();

        targetReservation
                .ifPresentOrElse(
                        reservations::remove,
                        () -> {
                            throw new ReservationException(ErrorCode.RESERVATION_NOT_FOUND);
                        }
                );
    }
}
