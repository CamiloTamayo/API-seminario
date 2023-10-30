package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.model.MaquinaFisica;

import java.util.List;

@Service
public interface MaquinaFisicaService {

    public MaquinaFisica crearMF(MaquinaFisica maquinaFisica);

    public void eliminarMF(MaquinaFisica maquinaFisica);

    public void actualizarMF(MaquinaFisica maquinaFisica);

    public List<MaquinaFisica> findAll();

    public MaquinaFisica obtenerMFID(Integer id);
}

