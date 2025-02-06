package roomescape.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.exception.ErrorCode;
import roomescape.exception.custom.ReservationException;

public class Reservation {

    private final long id;
    private final String name;
    private final LocalDate date;
    private final LocalTime time;

    public Reservation(
            long id,
            String name,
            LocalDate date,
            LocalTime time
    ) {
        validate(name, date, time);
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    private void validate(String name, LocalDate date, LocalTime time) {
        if (name == null || date == null || time == null) {
            throw new ReservationException(ErrorCode.INVALID_REQUEST);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
