package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.dto.CredentialsDTO;
import uniquindio.seminario.dto.UsuarioDTO;
import uniquindio.seminario.model.Usuario;
public interface UsuarioService {

    public Usuario obtenerUsuarioID(Integer id);

    public Usuario obtenerUsuarioCorreo(String correo);

    public UsuarioDTO guardarUsuario(Usuario usuario);

    public void borrarUsuario(Usuario usuario);

    public void actualizarUsuario(Usuario usuario);
    public UsuarioDTO login(CredentialsDTO credentialsDTO);
}
