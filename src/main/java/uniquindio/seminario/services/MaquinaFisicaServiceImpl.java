package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.repositories.MaquinaFisicaRepo;

import java.io.Serializable;

public class MaquinaFisicaServiceImpl implements MaquinaFisicaService, Serializable {

    @Autowired
    public MaquinaFisicaRepo maquinaFisicaRepo;

    @Override
    @Transactional(readOnly = false)
    public void crearMF(MaquinaFisica maquinaFisica) {
        maquinaFisicaRepo.save(maquinaFisica);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarMF(MaquinaFisica maquinaFisica) {
        maquinaFisicaRepo.delete(maquinaFisica);
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarMF(MaquinaFisica maquinaFisica) {

    }
}
