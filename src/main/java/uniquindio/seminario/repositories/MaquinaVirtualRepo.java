package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uniquindio.seminario.model.MaquinaVirtual;
import java.util.List;

@Repository
public interface MaquinaVirtualRepo extends JpaRepository<MaquinaVirtual, Integer> {

    @Query("select m from MaquinaVirtual m where m.usuario.id=:id")
    List<MaquinaVirtual> findByUser(Integer id);

    @Query("select m from MaquinaVirtual  m where m.id=:idVM")
    MaquinaVirtual obtenerDetalles(Integer idVM);
}
