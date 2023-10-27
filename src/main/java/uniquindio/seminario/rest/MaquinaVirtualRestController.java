package uniquindio.seminario.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.dto.CredentialsDTO;
import uniquindio.seminario.dto.MaquinaVirtualDTO;
import uniquindio.seminario.dto.UpdateDTO;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.model.MaquinaVirtual;
import uniquindio.seminario.model.TipoMaquina;
import uniquindio.seminario.model.Usuario;
import uniquindio.seminario.services.MaquinaFisicaService;
import uniquindio.seminario.services.MaquinaVirtualService;
import uniquindio.seminario.services.TipoMaquinaService;
import uniquindio.seminario.services.UsuarioService;
import java.util.List;

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

    @PostMapping("/savevm")
    public void guardarMV(@RequestBody MaquinaVirtualDTO mvDTO) throws JsonProcessingException {
        System.out.println("mvDTO: "+mvDTO);
        MaquinaFisica mf = maquinaFisicaService.obtenerMFID(1);
        Usuario usuario = usuarioService.obtenerUsuarioID(mvDTO.getIdUser());
        TipoMaquina tipoMaquina = tipoMaquinaService.obtenerTMId(Integer.parseInt("1"));
        MaquinaVirtual mv = new MaquinaVirtual(null, mvDTO.getNombre(), mvDTO.getIp(), mvDTO.getHostname(), usuario, mf, tipoMaquina , mvDTO.getEstado());
        maquinaVirtualService.guardarMV(mv);
    }

    @PostMapping("/getvms")
    public List<MaquinaVirtual> getMVs(@RequestBody Integer userId){
        System.out.println(userId);
        List<MaquinaVirtual> maquinas = maquinaVirtualService.obtenerMaquinasVirtuales(userId);
        return maquinas;
    }

    @PostMapping("/updatevms")
    public void actualizarEstado(@RequestBody UpdateDTO update){
        Integer userId = update.getId();
        String estado = update.getEstado();

        maquinaVirtualService.cambiarEstado(userId, estado);
    }

}
