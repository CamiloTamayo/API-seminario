package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.model.MaquinaVirtual;

import java.util.List;

@Repository
public interface MaquinaFisicaRepo extends JpaRepository<MaquinaFisica, Integer> {


}
