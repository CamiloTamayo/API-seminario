package uniquindio.seminario.services;

import org.springframework.beans.factory.annotation.Autowired;
import uniquindio.seminario.repositories.UsuarioRepo;
import uniquindio.seminario.model.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public class UsuarioServiceImpl implements UsuarioService, Serializable {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    @Transactional(readOnly = false)
    public void guardarUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
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
