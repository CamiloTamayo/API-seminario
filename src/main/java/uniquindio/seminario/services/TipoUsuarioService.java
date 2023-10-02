package uniquindio.seminario.services;

import uniquindio.seminario.model.TipoUsuario;

public interface TipoUsuarioService {
    public void guardarTipoUsuario(TipoUsuario tipoUsuario);

    public void eliminarTipoUsuario(TipoUsuario tipoUsuario);

    public void actualizarTipoUsuario(TipoUsuario tipoUsuario);
}
