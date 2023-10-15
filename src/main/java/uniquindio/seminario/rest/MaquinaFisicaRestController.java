package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.dto.MaquinaFisicaDTO;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.services.MaquinaFisicaService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MaquinaFisicaRestController {

    @Autowired
    private MaquinaFisicaService maquinaFisicaService;

    @GetMapping("/getmf/{id}")
    public MaquinaFisica obtenerMF(@PathVariable Integer id){
        return maquinaFisicaService.obtenerMFID(id);
    }
}
