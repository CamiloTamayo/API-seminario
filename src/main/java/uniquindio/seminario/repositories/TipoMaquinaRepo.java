package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniquindio.seminario.model.TipoMaquina;
@Repository
public interface TipoMaquinaRepo extends JpaRepository<TipoMaquina, Integer> {
}
