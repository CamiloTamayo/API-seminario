package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.model.MaquinaFisica;
@Service
public interface MaquinaFisicaService {

    public void crearMF(MaquinaFisica maquinaFisica);

    public void eliminarMF(MaquinaFisica maquinaFisica);

    public void actualizarMF(MaquinaFisica maquinaFisica);

    public MaquinaFisica obtenerMFID(Integer id);
}

