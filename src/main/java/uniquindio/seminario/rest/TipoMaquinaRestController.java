package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.dto.MensajeDTO;
import uniquindio.seminario.dto.TipoMaquinaDTO;
import uniquindio.seminario.model.TipoMaquina;
import uniquindio.seminario.services.TipoMaquinaService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TipoMaquinaRestController {
    @Autowired
    private TipoMaquinaService tipoMaquinaService;

    @GetMapping("/getTipoMaquina/{nombre}")
    public TipoMaquinaDTO getHostname(@PathVariable String nombre){
        TipoMaquina tipoMaquina = tipoMaquinaService.obtenerTMNombre(nombre);
        return new TipoMaquinaDTO(tipoMaquina.getRamMB(), tipoMaquina.getCpu(), tipoMaquina.getStorageGB());
    }
    @GetMapping("/getTiposMaquina")
    public List<TipoMaquina> getTipos(){
        return tipoMaquinaService.getTipos();
    }
}
