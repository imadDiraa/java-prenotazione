package server.exceptions;

public class ReservationExistsException extends Exception {
    public ReservationExistsException() {
        super();
    }

    public ReservationExistsException(String message) {
        super(message);
    }

    public ReservationExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationExistsException(Throwable cause) {
        super(cause);
    }
}
