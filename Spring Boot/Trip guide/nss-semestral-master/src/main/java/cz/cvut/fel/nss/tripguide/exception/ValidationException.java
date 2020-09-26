package cz.cvut.fel.nss.tripguide.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Signifies that invalid data have been provided to the application.
 */
@ResponseStatus(code = HttpStatus.CONFLICT)
public class ValidationException extends BaseException {

    /**
     * Instantiates a new Validation exception.
     *
     * @param message the message
     */
    public ValidationException(String message) {
        super(message);
    }
}
