package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.configuration.UserAuthProvider;
import uniquindio.seminario.dto.MensajeDTO;
import uniquindio.seminario.dto.UsuarioDTO;
import uniquindio.seminario.model.TipoUsuario;
import uniquindio.seminario.model.Usuario;
import uniquindio.seminario.services.TipoUsuarioService;
import uniquindio.seminario.services.UsuarioService;

import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Autowired
    UserAuthProvider userAuthProvider;
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> guardar(@RequestBody UsuarioDTO usuarioInput){
        TipoUsuario tipoUsuario = tipoUsuarioService.getTipoUsuario(Integer.parseInt(usuarioInput.getTipoUsuario()));
        Usuario usuario = new Usuario(usuarioInput.getNombre(), usuarioInput.getApellidos(), usuarioInput.getCorreo(), usuarioInput.getContrasenia(), tipoUsuario);
        UsuarioDTO usuarioDTO = usuarioService.guardarUsuario(usuario);
        usuarioDTO.setToken(userAuthProvider.createToken(usuarioDTO));
        return ResponseEntity.created(URI.create("/register/"+ usuarioDTO.getId())).body(usuarioDTO);
    }

    @PostMapping("/getUser")
    public  ResponseEntity<Usuario> getUser(@RequestBody String correo){
        Usuario user = usuarioService.obtenerUsuarioCorreo(correo);
        return ResponseEntity.created(URI.create("/getUser/"+ user.getCorreo())).body(user);
    }

    @PostMapping("/getUserEmail")
    public  ResponseEntity<Usuario> getUserEmail(@RequestBody String correo){
        Usuario user = usuarioService.obtenerUsuarioCorreo(correo);
        return ResponseEntity.created(URI.create("/getUserEmail/"+ user.getId())).body(user);
    }
}
