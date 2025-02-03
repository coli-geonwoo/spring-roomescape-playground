package roomescape.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.domain.Reservation;

public record ReservationResponse(
        long id,
        String name,
        @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate date,

        @JsonFormat(shape = Shape.STRING, pattern = "HH:mm")
        LocalTime time
) {
    public ReservationResponse(Reservation reservation) {
        this(reservation.getId(), reservation.getName(), reservation.getDate(), reservation.getTime());
    }
}
