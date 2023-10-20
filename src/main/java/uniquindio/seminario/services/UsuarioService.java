package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.model.Usuario;
@Service
public interface UsuarioService {

    public Usuario obtenerUsuarioID(Integer id);
    public Usuario guardarUsuario(Usuario usuario);

    public void borrarUsuario(Usuario usuario);

    public void actualizarUsuario(Usuario usuario);
}
