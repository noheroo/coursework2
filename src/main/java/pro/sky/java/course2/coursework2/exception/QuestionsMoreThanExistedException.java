package pro.sky.java.course2.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionsMoreThanExistedException extends RuntimeException{
    public QuestionsMoreThanExistedException() {
    }

    public QuestionsMoreThanExistedException(String message) {
        super(message);
    }

    public QuestionsMoreThanExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsMoreThanExistedException(Throwable cause) {
        super(cause);
    }

    public QuestionsMoreThanExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
