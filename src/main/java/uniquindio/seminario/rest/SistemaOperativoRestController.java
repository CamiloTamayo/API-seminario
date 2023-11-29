package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniquindio.seminario.model.SistemaOperativo;
import uniquindio.seminario.services.SistemaOperativoService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SistemaOperativoRestController {

    @Autowired
    private SistemaOperativoService sistemaOperativoService;
    @GetMapping("/getOSs")
    public List<SistemaOperativo> getSOs(){
        return this.sistemaOperativoService.obtenerSistemas();
    }
}
