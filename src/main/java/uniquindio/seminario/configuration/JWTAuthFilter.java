package uniquindio.seminario.configuration;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uniquindio.seminario.exceptions.AppException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component("delegatedAuthenticationEntryPoint")
@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {
    private final UserAuthProvider userAuthProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JWTFILTER");
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("SE LEE EL HEADER"+ header);
        if(header!=null){
            String[] authElements = header.split(" ");
            if(authElements.length == 2 && "Bearer".equals(authElements[0])){
                Authentication auth = userAuthProvider.validateToken(authElements[1]);
                System.out.println("SE VALIDA EL TOKEN");
                if(auth!=null || request.getRequestURL().toString().contains("login")){
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }else{
                    SecurityContextHolder.clearContext();
                    AppException appException = new AppException("Sesion expirada", HttpStatus.UNAUTHORIZED);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    OutputStream responseStream = response.getOutputStream();
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(responseStream, appException);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
