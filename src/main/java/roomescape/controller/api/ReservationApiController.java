package roomescape.controller.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import roomescape.domain.Reservation;

@RestController
public class ReservationApiController {

    private final List<Reservation> reservations = new ArrayList<>();

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        reservations.add(new Reservation(1L, "브라운", LocalDate.of(2023, 1, 1), LocalTime.of(10, 00)));
        reservations.add(new Reservation(1L, "브라운", LocalDate.of(2023, 1, 2), LocalTime.of(11, 00)));
        return ResponseEntity.ok(reservations);
    }
}
