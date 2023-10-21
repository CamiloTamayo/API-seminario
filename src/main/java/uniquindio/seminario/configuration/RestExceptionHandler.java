package uniquindio.seminario.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import uniquindio.seminario.dto.ErrorDTO;
import uniquindio.seminario.exceptions.AppException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppException e){
        return ResponseEntity.status(e.getHttpStatus())
                .body(new ErrorDTO(e.getMessage()));
    }
}
