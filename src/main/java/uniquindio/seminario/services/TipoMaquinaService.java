package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.model.TipoMaquina;
@Service
public interface TipoMaquinaService {
    public TipoMaquina obtenerTMId(Integer id);
    public void guardarTipoMaquina(TipoMaquina tipoMaquina);
    public void eliminarTipoMaquina(TipoMaquina tipoMaquina);
    public void actualizarTipoMaquina(TipoMaquina tipoMaquina);

    String obtenerTipo(Integer id);
}
