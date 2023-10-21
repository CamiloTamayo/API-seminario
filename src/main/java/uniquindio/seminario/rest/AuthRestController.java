package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.configuration.UserAuthProvider;
import uniquindio.seminario.dto.CredentialsDTO;
import uniquindio.seminario.dto.UsuarioDTO;
import uniquindio.seminario.services.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthRestController {
    @Autowired
    UsuarioService userService;
    @Autowired
    UserAuthProvider userAuthProvider;
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody CredentialsDTO credentialsDTO){
        UsuarioDTO usuarioDTO = userService.login(credentialsDTO);
        usuarioDTO.setToken(userAuthProvider.createToken(usuarioDTO));
        return ResponseEntity.ok(usuarioDTO);
    }
}
