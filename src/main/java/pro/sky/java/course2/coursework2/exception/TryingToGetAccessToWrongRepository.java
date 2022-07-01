package pro.sky.java.course2.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class TryingToGetAccessToWrongRepository extends RuntimeException{
    public TryingToGetAccessToWrongRepository() {
    }

    public TryingToGetAccessToWrongRepository(String message) {
        super(message);
    }

    public TryingToGetAccessToWrongRepository(String message, Throwable cause) {
        super(message, cause);
    }

    public TryingToGetAccessToWrongRepository(Throwable cause) {
        super(cause);
    }

    public TryingToGetAccessToWrongRepository(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
