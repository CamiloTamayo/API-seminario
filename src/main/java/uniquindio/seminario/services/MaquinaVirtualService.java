package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.model.MaquinaVirtual;
@Service
public interface MaquinaVirtualService {
    public void guardarMV(MaquinaVirtual mv);
    public void eliminarMV(MaquinaVirtual mv);
    public void actualizarMV(MaquinaVirtual mv);
}
