package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.model.MaquinaVirtual;
import uniquindio.seminario.repositories.MaquinaVirtualRepo;

import java.io.Serializable;
@Component
public class MaquinaVirtualServiceImpl implements MaquinaVirtualService, Serializable {

    @Autowired
    private MaquinaVirtualRepo mvRepo;

    @Override
    @Transactional(readOnly = false)
    public void guardarMV(MaquinaVirtual mv) {
        mvRepo.save(mv);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarMV(MaquinaVirtual mv) {
        mvRepo.delete(mv);
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarMV(MaquinaVirtual mv) {
    }
}
