package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.dto.HostNameDTO;
import uniquindio.seminario.dto.MaquinaVirtualDTO;
import uniquindio.seminario.services.TipoMaquinaService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TipoMaquinaRestController {
    @Autowired
    private TipoMaquinaService tipoMaquinaService;

    @GetMapping("/getHostname/{id}")
    public HostNameDTO getHostname(@PathVariable Integer id){
        return new HostNameDTO(tipoMaquinaService.obtenerTipo(id));
    }
}
