package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.repositories.MaquinaFisicaRepo;

import java.io.Serializable;
@Component
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

    @Override
    public MaquinaFisica obtenerMFID(Integer id) {
        return maquinaFisicaRepo.findById(id).get();
    }
}
