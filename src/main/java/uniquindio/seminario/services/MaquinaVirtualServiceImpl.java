package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.dto.MaquinaVirtualDTO;
import uniquindio.seminario.model.MaquinaVirtual;
import uniquindio.seminario.repositories.MaquinaVirtualRepo;
import uniquindio.seminario.repositories.UsuarioRepo;
import java.util.List;
import java.io.Serializable;

@Component
public class MaquinaVirtualServiceImpl implements MaquinaVirtualService, Serializable {

    @Autowired
    private MaquinaVirtualRepo mvRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    @Transactional(readOnly = false)
    public MaquinaVirtualDTO guardarMV(MaquinaVirtual mv) {

        MaquinaVirtual vm = mvRepo.save(mv);
        String nombre = vm.getNombre()+vm.getId();
        MaquinaVirtualDTO maquinaDTO = new MaquinaVirtualDTO(vm.getId()+"", vm.getNombre(), vm.getIp(), vm.getHostname(), vm.getUsuario().getId(), vm.getEstado(), vm.getTipoMaquina().getNombre(), vm.getMfisica().getIdMF());
        mvRepo.actualizarNombre(vm.getId(), nombre);
        return maquinaDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarMV(MaquinaVirtual mv) {
        mvRepo.delete(mv);
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarMV(MaquinaVirtual mv) {
    }
    public List<MaquinaVirtual> obtenerMaquinasVirtuales(Integer userId) {
        List<MaquinaVirtual> maquinas = mvRepo.findByUser(userId);
       System.out.println("lista"+maquinas.size());
        return maquinas;
    }
    public void cambiarEstado(Integer  UserId, String estadoNuevo){
        mvRepo.cambiarEstado(UserId, estadoNuevo);
    }


}
