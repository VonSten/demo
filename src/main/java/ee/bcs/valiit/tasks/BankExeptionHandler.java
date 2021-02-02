package ee.bcs.valiit.tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BankExeptionHandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler(Exception.class)
public ResponseEntity<Object> bankError(BankExeption ex){

             BankResponseBody error = new BankResponseBody(ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
}
