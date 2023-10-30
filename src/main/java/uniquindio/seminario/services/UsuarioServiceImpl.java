package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uniquindio.seminario.dto.CredentialsDTO;
import uniquindio.seminario.dto.UsuarioDTO;
import uniquindio.seminario.exceptions.AppException;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.repositories.UsuarioRepo;
import uniquindio.seminario.model.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioServiceImpl implements UsuarioService, Serializable {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario obtenerUsuarioID(Integer id) {
        return usuarioRepo.findById(id).get();
    }

    @Override
    public Usuario obtenerUsuarioCorreo(String correo) {
        String correoABuscar = correo.replace("\"", "");
        return usuarioRepo.findByCorreo(correoABuscar);
    }

    @Override
    @Transactional(readOnly = false)
    public void borrarUsuario(Usuario usuario) {
        usuarioRepo.delete(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarUsuario(Usuario usuario) {
    }

    public UsuarioDTO login(CredentialsDTO credentialsDTO){
        UsuarioDTO usuarioDTO;
        Usuario usuario = Optional.ofNullable(usuarioRepo.findByCorreo(credentialsDTO.getCorreo()))
                .orElseThrow(() -> new AppException("Usuario desconocido", HttpStatus.NOT_FOUND));
        System.out.println("USUARIO"+ usuario.getNombre());
        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.getPassword()), usuario.getContrasenia())){
            return usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getApellidos(), usuario.getContrasenia());
        }
        throw new AppException("Contraseña incorrecta", HttpStatus.BAD_REQUEST);
    }
    public UsuarioDTO guardarUsuario(Usuario usuarioDTO){
        Optional<Usuario>oUser = Optional.ofNullable(usuarioRepo.findByCorreo(usuarioDTO.getCorreo()));
        if(oUser.isPresent()){
            throw new AppException("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        usuarioDTO.setContrasenia(passwordEncoder.encode(CharBuffer.wrap(usuarioDTO.getContrasenia())));
        System.out.println(usuarioDTO.getContrasenia());
        Usuario savedUser = usuarioRepo.save(usuarioDTO);
        return new UsuarioDTO(savedUser.getId(), savedUser.getNombre(), savedUser.getCorreo(), savedUser.getApellidos(), savedUser.getContrasenia());
    }


}
