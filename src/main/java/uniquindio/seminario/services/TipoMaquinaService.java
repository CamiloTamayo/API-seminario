package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.model.TipoMaquina;

import java.util.List;

@Service
public interface TipoMaquinaService {
    public TipoMaquina obtenerTMNombre(String nombre);
    public List<TipoMaquina> getTipos();
    String obtenerTipo(Integer id);
}
