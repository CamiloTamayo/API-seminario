package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.model.TipoUsuario;
import uniquindio.seminario.repositories.TipoUsuarioRepo;

import java.io.Serializable;
@Component
public class TipoUsuarioServiceImpl implements TipoUsuarioService, Serializable {

    @Autowired
    private TipoUsuarioRepo tipoUsuarioRepo;

    @Override
    @Transactional(readOnly = false)
    public void guardarTipoUsuario(TipoUsuario tipoUsuario) {
        tipoUsuarioRepo.save(tipoUsuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarTipoUsuario(TipoUsuario tipoUsuario) {
        tipoUsuarioRepo.delete(tipoUsuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarTipoUsuario(TipoUsuario tipoUsuario) {

    }
}
