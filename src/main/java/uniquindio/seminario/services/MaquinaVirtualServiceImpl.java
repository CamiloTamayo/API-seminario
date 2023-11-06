package uniquindio.seminario.services;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.dto.MaquinaVirtualDTO;
import uniquindio.seminario.model.MaquinaVirtual;
import uniquindio.seminario.repositories.MaquinaVirtualRepo;
import uniquindio.seminario.repositories.UsuarioRepo;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
@EnableEncryptableProperties
@Component
public class MaquinaVirtualServiceImpl implements MaquinaVirtualService, Serializable {

    @Autowired
    private MaquinaVirtualRepo mvRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Override
    @Transactional(readOnly = false)
    public MaquinaVirtualDTO guardarMV(MaquinaVirtual mv){
        MaquinaVirtual vm = mvRepo.save(mv);
        String nombre = vm.getNombre()+vm.getId();
        MaquinaVirtualDTO maquinaDTO = new MaquinaVirtualDTO(vm.getId()+"", vm.getNombre(), vm.getIp(), vm.getHostname(), vm.getUsuario().getId(), vm.getContrasenia(), vm.getEstado(), vm.getTipoMaquina().getId(), vm.getMfisica().getIdMF());
        //mvRepo.actualizarNombre(vm.getId(), nombre);
        return maquinaDTO;
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
       System.out.println("lista"+maquinas.size());
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
        System.out.println(mvRepo.obtenerUltimaVM()+"idUltima");
        return mvRepo.obtenerUltimaVM();
    }
}
