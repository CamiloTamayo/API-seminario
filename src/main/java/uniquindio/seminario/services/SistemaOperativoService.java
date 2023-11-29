package uniquindio.seminario.services;

import org.springframework.stereotype.Service;
import uniquindio.seminario.model.SistemaOperativo;

import java.util.List;
@Service
public interface SistemaOperativoService {
    List<SistemaOperativo> obtenerSistemas();
    SistemaOperativo getSistema(Integer id);
}
