package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.model.TipoUsuario;
@Service
public interface TipoUsuarioService {
    public void guardarTipoUsuario(TipoUsuario tipoUsuario);

    public void eliminarTipoUsuario(TipoUsuario tipoUsuario);

    public void actualizarTipoUsuario(TipoUsuario tipoUsuario);

    public TipoUsuario getTipoUsuario(int id);
}
