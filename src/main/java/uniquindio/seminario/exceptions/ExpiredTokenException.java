package uniquindio.seminario.exceptions;


import org.springframework.security.core.AuthenticationException;

public class ExpiredTokenException extends RuntimeException {
    public ExpiredTokenException(String message) {
        super(message);
    }
}