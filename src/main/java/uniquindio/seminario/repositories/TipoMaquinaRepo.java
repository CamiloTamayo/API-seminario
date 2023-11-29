package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uniquindio.seminario.model.TipoMaquina;
@Repository
public interface TipoMaquinaRepo extends JpaRepository<TipoMaquina, Integer> {
    @Query("select t.nombre from TipoMaquina t WHERE t.id = :id")
    String obtenerTipo(@Param("id") Integer id);

    @Query("select t from TipoMaquina t WHERE t.nombre = :nombre")
    TipoMaquina obtenerTipoNombre(@Param("nombre") String nombre);
}
