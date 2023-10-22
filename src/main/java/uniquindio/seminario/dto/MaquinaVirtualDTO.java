package uniquindio.seminario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaquinaVirtualDTO {
    String estado;
    String hostname;
    String ip;
    String nombre;
    Integer idMF;
    Integer idUser;
    Integer tipoMV;

    public MaquinaVirtualDTO(String estado, String hostname, String ip, String nombre, Integer idMF, Integer idUser, Integer tipoMV) {
        this.estado = estado;
        this.hostname = hostname;
        this.ip = ip;
        this.nombre = nombre;
        this.idMF = idMF;
        this.idUser = idUser;
        this.tipoMV = tipoMV;
    }
}


