package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.model.TipoMaquina;
import uniquindio.seminario.repositories.TipoMaquinaRepo;

import java.io.Serializable;

public class TipoMaquinaServiceImpl implements TipoMaquinaService, Serializable {

    @Autowired
    private TipoMaquinaRepo tipoMaquinaRepo;

    @Override
    @Transactional(readOnly = false)
    public void guardarTipoMaquina(TipoMaquina tipoMaquina) {
        tipoMaquinaRepo.save(tipoMaquina);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarTipoMaquina(TipoMaquina tipoMaquina) {
        tipoMaquinaRepo.delete(tipoMaquina);
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarTipoMaquina(TipoMaquina tipoMaquina) {

    }

}
