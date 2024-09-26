package pro.sky.java.course2.coursework2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountQuestionsMoreThanExistedException extends RuntimeException{
    public AmountQuestionsMoreThanExistedException() {
    }

    public AmountQuestionsMoreThanExistedException(String message) {
        super(message);
    }

    public AmountQuestionsMoreThanExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountQuestionsMoreThanExistedException(Throwable cause) {
        super(cause);
    }

    public AmountQuestionsMoreThanExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
