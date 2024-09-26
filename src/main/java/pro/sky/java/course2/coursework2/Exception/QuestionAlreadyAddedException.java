package pro.sky.java.course2.coursework2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class QuestionAlreadyAddedException extends RuntimeException{
    public QuestionAlreadyAddedException() {
    }

    public QuestionAlreadyAddedException(String message) {
        super(message);
    }

    public QuestionAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public QuestionAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
