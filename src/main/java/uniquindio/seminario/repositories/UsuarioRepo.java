package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uniquindio.seminario.model.Usuario;
@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{

    @Query("select u from Usuario u where u.nombre=:nombre")
    Usuario findByNombre(String nombre);


}
