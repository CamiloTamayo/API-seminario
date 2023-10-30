package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.dto.CredentialsDTO;
import uniquindio.seminario.dto.MaquinaVirtualDTO;
import uniquindio.seminario.model.MaquinaVirtual;

import java.util.List;

@Service
public interface MaquinaVirtualService {
    public MaquinaVirtualDTO guardarMV(MaquinaVirtual mv);
    public void eliminarMV(MaquinaVirtual mv);
    public void actualizarMV(MaquinaVirtual mv);

    public List<MaquinaVirtual> obtenerMaquinasVirtuales(Integer userId);

    public void cambiarEstado(Integer userId, String nuevoEstado);

    public Integer obtenerUltimaVM();
}
