package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uniquindio.seminario.model.SistemaOperativo;
import uniquindio.seminario.repositories.SistemaOperativoRepo;

import java.io.Serializable;
import java.util.List;
@Component
public class SistemaOperativoServiceImpl implements SistemaOperativoService, Serializable {
    @Autowired
    private SistemaOperativoRepo sistemaOperativoRepo;
    @Override
    public List<SistemaOperativo> obtenerSistemas() {
        return this.sistemaOperativoRepo.findAll();
    }

    @Override
    public SistemaOperativo getSistema(Integer id) {
        return sistemaOperativoRepo.findById(id).orElse(null);
    }
}
