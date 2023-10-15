package uniquindio.seminario.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.dto.MaquinaVirtualDTO;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.model.MaquinaVirtual;
import uniquindio.seminario.model.TipoMaquina;
import uniquindio.seminario.model.Usuario;
import uniquindio.seminario.services.MaquinaFisicaService;
import uniquindio.seminario.services.MaquinaVirtualService;
import uniquindio.seminario.services.TipoMaquinaService;
import uniquindio.seminario.services.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MaquinaVirtualRestController {

    @Autowired
    private MaquinaVirtualService maquinaVirtualService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MaquinaFisicaService maquinaFisicaService;
    @Autowired
    private TipoMaquinaService tipoMaquinaService;

    @PostMapping("/savemv")
    public void guardarMV(@RequestBody String jsonBody) throws JsonProcessingException {
        MaquinaVirtualDTO mvDTO = new ObjectMapper().readValue(jsonBody, MaquinaVirtualDTO.class);
        MaquinaFisica mf = maquinaFisicaService.obtenerMFID(mvDTO.getIdMF());
        Usuario usuario = usuarioService.obtenerUsuarioID(mvDTO.getIdUser());
        TipoMaquina tipoMaquina = tipoMaquinaService.obtenerTMId(mvDTO.getTipoMV());
        MaquinaVirtual mv = new MaquinaVirtual(null, mvDTO.getNombre(), mvDTO.getIp(), mvDTO.getHostname(), usuario, mf, tipoMaquina, mvDTO.getEstado());
        maquinaVirtualService.guardarMV(mv);
    }
}
