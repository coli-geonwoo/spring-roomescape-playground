package roomescape.exception.custom;

import org.springframework.http.HttpStatus;
import roomescape.exception.ErrorCode;

public class ReservationException extends RuntimeException {

    private final ErrorCode errorCode;

    public ReservationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public HttpStatus getStatus() {
        return errorCode.getStatus();
    }
}
