package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.seminario.model.SistemaOperativo;

@Repository
@Transactional
public interface SistemaOperativoRepo extends JpaRepository<SistemaOperativo, Integer> {
}
