package uniquindio.seminario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler ({ AppException.class })
    @ResponseBody
    public ResponseEntity<AppException> handleAuthenticationException(Exception ex) {
        AppException re = new AppException("Authentication failed at controller advice", HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(re);
    }
}
