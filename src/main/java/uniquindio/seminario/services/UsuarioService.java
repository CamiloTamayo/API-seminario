package uniquindio.seminario.services;

import uniquindio.seminario.model.Usuario;

public interface UsuarioService {

    public void guardarUsuario(Usuario usuario);

    public void borrarUsuario(Usuario usuario);

    public void actualizarUsuario(Usuario usuario);
}
