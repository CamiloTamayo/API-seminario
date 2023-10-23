package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.dto.CredentialsDTO;
import uniquindio.seminario.model.MaquinaVirtual;
import uniquindio.seminario.model.Usuario;
import uniquindio.seminario.repositories.MaquinaVirtualRepo;
import uniquindio.seminario.repositories.UsuarioRepo;

import java.util.List;
import java.io.Serializable;
import java.util.Optional;

@Component
public class MaquinaVirtualServiceImpl implements MaquinaVirtualService, Serializable {

    @Autowired
    private MaquinaVirtualRepo mvRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    @Transactional(readOnly = false)
    public void guardarMV(MaquinaVirtual mv) {
        mvRepo.save(mv);
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
        //System.out.println("Credenciales: "+ credentialsDTO.getId()+ credentialsDTO.getPassword());
        System.out.println("lista"+maquinas.size());
        return maquinas;
    }
}
