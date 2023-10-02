package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniquindio.seminario.model.MaquinaVirtual;

@Repository
public interface MaquinaVirtualRepo extends JpaRepository<MaquinaVirtual, Integer> {
}
