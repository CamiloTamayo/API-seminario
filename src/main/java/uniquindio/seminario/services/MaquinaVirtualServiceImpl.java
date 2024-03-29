package uniquindio.seminario.services;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.dto.MaquinaVirtualDTO;
import uniquindio.seminario.model.MaquinaVirtual;
import uniquindio.seminario.model.TipoMaquina;
import uniquindio.seminario.repositories.MaquinaVirtualRepo;
import uniquindio.seminario.repositories.TipoMaquinaRepo;

import java.util.List;
import java.io.Serializable;
@EnableEncryptableProperties
@Component
public class MaquinaVirtualServiceImpl implements MaquinaVirtualService, Serializable {

    @Autowired
    private MaquinaVirtualRepo mvRepo;
    @Override
    @Transactional(readOnly = false)
    public MaquinaVirtualDTO guardarMV(MaquinaVirtual mv){
        MaquinaVirtual vm = mvRepo.save(mv);
        return new MaquinaVirtualDTO(vm.getId(), vm.getNombre(), vm.getIp(), vm.getHostname(), vm.getUsuario().getId(), vm.getContrasenia(), vm.getEstado(), vm.getTipoMaquina().getNombre(), vm.getMfisica().getIdMF(), vm.getSistemaOperativo().getId());
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarMV(Integer vmId) {
        mvRepo.eliminarVM(vmId);
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarMV(MaquinaVirtual mv) {
    }
    public List<MaquinaVirtual> obtenerMaquinasVirtuales(Integer userId) {
        List<MaquinaVirtual> maquinas = mvRepo.findByUser(userId);
        return maquinas;
    }

    public List<MaquinaVirtual> obtenerMaquinasVirtualesFM(Integer PMId) {
        List<MaquinaVirtual> maquinas = mvRepo.findByPM(PMId);
        return maquinas;
    }

    @Override
    public MaquinaVirtual getVM(Integer idVM) {
        return mvRepo.findById(idVM).orElse(null);
    }

    public void cambiarEstado(Integer  UserId, String estadoNuevo){
        mvRepo.cambiarEstado(UserId, estadoNuevo);
    }

    @Override
    public void cambiarIP(Integer userId, String nuevaIP) {
        mvRepo.cambiarIP(userId, nuevaIP);
    }

    @Override
    public void cambiarHostname(Integer userId, String hostname) {
        mvRepo.cambiarHostname(userId, hostname);
    }

    public Integer obtenerUltimaVM(){
        return mvRepo.obtenerUltimaVM();
    }

    @Override
    public void eliminarVmsUsuario(Integer idUsuario) {
        mvRepo.eliminarVMsUser(idUsuario);
    }

    @Override
    public boolean verificarNombre(String nombre) {
        if(mvRepo.findByNombre(nombre)!=null){
            return true;
        }
        return false;
    }

}
