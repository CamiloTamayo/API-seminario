package uniquindio.seminario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.seminario.dto.MensajeDTO;
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
    public MaquinaVirtualDTO guardarMV(@RequestBody MaquinaVirtualDTO mvDTO) {
        MaquinaFisica mf = maquinaFisicaService.obtenerMFID(mvDTO.getIdMF());
        Usuario usuario = usuarioService.obtenerUsuarioID(mvDTO.getIdUser());
        TipoMaquina tipoMaquina = tipoMaquinaService.obtenerTMId(mvDTO.getTipoMV());
        MaquinaVirtual mv = new MaquinaVirtual(null, mvDTO.getNombre(), mvDTO.getIp(), mvDTO.getHostname(), mvDTO.getContrasenia(), usuario, mf, tipoMaquina , mvDTO.getEstado());
        return maquinaVirtualService.guardarMV(mv);
    }

    @PostMapping("/getvms")
    public List<MaquinaVirtual> getMVs(@RequestBody Integer userId){
        List<MaquinaVirtual> maquinas = maquinaVirtualService.obtenerMaquinasVirtuales(userId);
        return maquinas;
    }

    @PostMapping("/getvmspm")
    public List<MaquinaVirtual> getMVsPM(@RequestBody Integer PMId){
        System.out.println(PMId);
        List<MaquinaVirtual> maquinas = maquinaVirtualService.obtenerMaquinasVirtualesFM(PMId);
        return maquinas;
    }

    @PostMapping("/getvm")
    public MaquinaVirtual getVM(@RequestBody Integer idVM){
        return maquinaVirtualService.getVM(idVM);
    }

    @PostMapping("/updatevms")
    public MensajeDTO actualizarEstado(@RequestBody UpdateDTO update){
        Integer userId = update.getId();
        String estado = update.getCambio();
        System.out.println("Estado: "+estado);
        maquinaVirtualService.cambiarEstado(userId, estado);
        return new MensajeDTO(estado);
    }

    @PostMapping("/updatevmi")
    public void actualizarIP(@RequestBody UpdateDTO update){
        Integer userId = update.getId();
        String ip = update.getCambio();
        maquinaVirtualService.cambiarIP(userId, ip);
    }

    @PostMapping("/updatevmh")
    public void actualizarHostname(@RequestBody UpdateDTO update){
        Integer userId = update.getId();
        String hostname = update.getCambio();
        maquinaVirtualService.cambiarHostname(userId, hostname);
    }

    @GetMapping("/obtenerMayor")
    public Integer obtenerUltimaVM(){
        return maquinaVirtualService.obtenerUltimaVM();
    }

    @DeleteMapping("/deletevm")
    public void eliminarVM(@RequestBody UpdateDTO update){
        Integer vmId = update.getId();

        maquinaVirtualService.eliminarMV(vmId);
    }
    @PostMapping("/verificarNombre")
    public MensajeDTO verificarNombre(@RequestBody MensajeDTO mensaje){
        boolean exists = maquinaVirtualService.verificarNombre(mensaje.getNombre());
        MensajeDTO respuesta = new MensajeDTO(Boolean.toString(exists));
        return respuesta;
    }
}
