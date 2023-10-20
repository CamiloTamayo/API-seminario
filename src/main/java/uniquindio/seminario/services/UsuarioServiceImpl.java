package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uniquindio.seminario.repositories.UsuarioRepo;
import uniquindio.seminario.model.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
@Component
public class UsuarioServiceImpl implements UsuarioService, Serializable {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public Usuario obtenerUsuarioID(Integer id) {
        return usuarioRepo.findById(id).get();
    }

    @Override
    @Transactional(readOnly = false)
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }
    @Override
    @Transactional(readOnly = false)
    public void borrarUsuario(Usuario usuario) {
        usuarioRepo.delete(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarUsuario(Usuario usuario) {

    }
}
