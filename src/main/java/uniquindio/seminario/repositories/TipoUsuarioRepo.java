package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniquindio.seminario.model.TipoUsuario;
@Repository
public interface TipoUsuarioRepo extends JpaRepository<TipoUsuario, Integer> {
}
