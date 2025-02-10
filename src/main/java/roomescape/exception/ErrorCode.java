package roomescape.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    RESERVATION_NOT_FOUND(HttpStatus.BAD_REQUEST, "reservation not found"),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "invalid request"),
    DATA_ACCESS_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "data access exception"),
    ;

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
