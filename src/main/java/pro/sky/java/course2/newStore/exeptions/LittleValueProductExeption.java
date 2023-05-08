package pro.sky.java.course2.newStore.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LittleValueProductExeption extends RuntimeException {
    public LittleValueProductExeption(String message) {
        super(message);
    }
}
