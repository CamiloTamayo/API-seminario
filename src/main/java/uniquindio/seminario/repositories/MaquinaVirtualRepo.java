package uniquindio.seminario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uniquindio.seminario.model.MaquinaFisica;
import uniquindio.seminario.model.MaquinaVirtual;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MaquinaVirtualRepo extends JpaRepository<MaquinaVirtual, Integer> {

    @Query("select m from MaquinaVirtual m where m.usuario.id=:id")
    List<MaquinaVirtual> findByUser(Integer id);

    @Query("select m from MaquinaVirtual m where m.mfisica.idMF=:PMid")
    List<MaquinaVirtual> findByPM(Integer PMid);

    @Modifying
    @Query("UPDATE MaquinaVirtual m SET m.estado = :estado WHERE m.id = :idVM")
    void cambiarEstado(@Param("idVM") Integer idVM, @Param("estado") String estado);

    @Modifying
    @Query("UPDATE MaquinaVirtual m SET m.ip = :ip WHERE m.id = :idVM")
    void cambiarIP(@Param("idVM") Integer idVM, @Param("ip") String ip);

    @Modifying
    @Query("UPDATE MaquinaVirtual m SET m.hostname = :hostname WHERE m.id = :idVM")
    void cambiarHostname(@Param("idVM") Integer idVM, @Param("hostname") String hostname);

    @Query("select m.id from MaquinaVirtual m WHERE m.id = (SELECT MAX(id) FROM MaquinaVirtual)")
    Integer obtenerUltimaVM();

    @Query("select m from MaquinaVirtual m WHERE m.nombre = :nombre")
    MaquinaVirtual findByNombre(@Param("nombre") String nombre);

    @Modifying
    @Query("DELETE FROM MaquinaVirtual WHERE id = :idVM")
    void eliminarVM(@Param("idVM") Integer idVM);
    @Modifying
    @Query("DELETE FROM MaquinaVirtual m WHERE m.usuario.id = :idUser")
    void eliminarVMsUser(@Param("idUser") Integer idUser);

}
