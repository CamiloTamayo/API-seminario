package uniquindio.seminario.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import uniquindio.seminario.dto.UsuarioDTO;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(UsuarioDTO usuarioDTO){
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3_600_000);
        return JWT.create()
                .withIssuer(usuarioDTO.getCorreo())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim("nombre", usuarioDTO.getNombre())
                .withClaim("apellidos", usuarioDTO.getApellidos())
                .withClaim("id", usuarioDTO.getId())
                .withClaim("correo", usuarioDTO.getCorreo())
                .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .correo(decodedJWT.getIssuer())
                .nombre(decodedJWT.getClaim("nombre").asString())
                .apellidos(decodedJWT.getClaim("apellidos").asString())
                .build();
        return new UsernamePasswordAuthenticationToken(usuarioDTO, null, Collections.emptyList());
    }
}
