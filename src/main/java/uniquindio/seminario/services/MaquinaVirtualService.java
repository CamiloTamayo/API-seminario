package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.dto.CredentialsDTO;
import uniquindio.seminario.model.MaquinaVirtual;

import java.util.List;

@Service
public interface MaquinaVirtualService {
    public void guardarMV(MaquinaVirtual mv);
    public void eliminarMV(MaquinaVirtual mv);
    public void actualizarMV(MaquinaVirtual mv);

    public List<MaquinaVirtual> obtenerMaquinasVirtuales(Integer userId);
}
