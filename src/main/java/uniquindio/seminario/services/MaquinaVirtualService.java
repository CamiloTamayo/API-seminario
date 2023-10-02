package uniquindio.seminario.services;

import uniquindio.seminario.model.MaquinaVirtual;

public interface MaquinaVirtualService {
    public void guardarMV(MaquinaVirtual mv);
    public void eliminarMV(MaquinaVirtual mv);
    public void actualizarMV(MaquinaVirtual mv);
}
