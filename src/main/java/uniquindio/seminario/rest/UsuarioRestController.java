package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.configuration.UserAuthProvider;
import uniquindio.seminario.dto.UsuarioDTO;
import uniquindio.seminario.model.Usuario;
import uniquindio.seminario.services.UsuarioService;

import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    UserAuthProvider userAuthProvider;
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> guardar(@RequestBody Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getApellidos(), usuario.getContrasenia());
        usuarioDTO.setToken(userAuthProvider.createToken(usuarioDTO));
        usuarioService.guardarUsuario(usuario);
        return ResponseEntity.created(URI.create("/register/"+ usuarioDTO.getId())).body(usuarioDTO);
    }

    @PostMapping("/getUser")
    public  ResponseEntity<Usuario> getUser(@RequestBody String userId){
        Usuario user = usuarioService.obtenerUsuarioID(Integer.parseInt(userId));
        return ResponseEntity.created(URI.create("/getUser/"+ user.getId())).body(user);
    }

}
