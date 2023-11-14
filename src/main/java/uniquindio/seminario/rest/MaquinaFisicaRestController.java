package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.dto.MaquinaFisicaDTO;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.services.MaquinaFisicaService;

import java.util.List;

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

    @GetMapping("/getmfs")
    public List<MaquinaFisica> obtenerMF(){
        return maquinaFisicaService.findAll();
    }

    @PostMapping("/savepm")
    public MaquinaFisica guardarMF(@RequestBody MaquinaFisicaDTO mf){
        MaquinaFisica mfisica = new MaquinaFisica(mf.getIp(), mf.getRam(), mf.getCpu(), mf.getAlmacenamiento(), mf.getHostname(), mf.getOs(), mf.getAdaptador(), null);
        return maquinaFisicaService.crearMF(mfisica);

    }

}
