package cz.cvut.fel.nss.tripguide.exception;

/**
 * Base for all application-specific exceptions.
 */
public class EarException extends RuntimeException {

    /**
     * Instantiates a new Ear exception.
     */
    public EarException() {
    }

    /**
     * Instantiates a new Ear exception.
     *
     * @param message the message
     */
    public EarException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Ear exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public EarException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Ear exception.
     *
     * @param cause the cause
     */
    public EarException(Throwable cause) {
        super(cause);
    }
}
