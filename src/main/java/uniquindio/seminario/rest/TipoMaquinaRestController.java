package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.dto.MensajeDTO;
import uniquindio.seminario.services.TipoMaquinaService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TipoMaquinaRestController {
    @Autowired
    private TipoMaquinaService tipoMaquinaService;

    @GetMapping("/getHostname/{id}")
    public MensajeDTO getHostname(@PathVariable Integer id){
        return new MensajeDTO(tipoMaquinaService.obtenerTipo(id));
    }
}
