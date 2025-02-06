package roomescape.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.domain.Reservation;

public record ReservationSaveRequest(
        LocalDate date,
        LocalTime time,
        String name
) {

    public Reservation toReservation(long id) {
        return new Reservation(id, name, date, time);
    }
}
