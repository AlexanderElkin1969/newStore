package pro.sky.java.course2.newStore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LittleValueProductException extends RuntimeException {
    public LittleValueProductException(String message) {
        super(message);
    }
}
