package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.model.TipoMaquina;
import uniquindio.seminario.repositories.TipoMaquinaRepo;

import java.io.Serializable;
import java.util.List;

@Component
public class TipoMaquinaServiceImpl implements TipoMaquinaService, Serializable {

    @Autowired
    private TipoMaquinaRepo tipoMaquinaRepo;

    @Override
    public TipoMaquina obtenerTMNombre(String nombre) {
        return tipoMaquinaRepo.obtenerTipoNombre(nombre);
    }

    @Override
    public List<TipoMaquina> getTipos() {
        return tipoMaquinaRepo.findAll();
    }


    @Override
    public String obtenerTipo(Integer id) {
        return tipoMaquinaRepo.obtenerTipo(id);
    }

}
