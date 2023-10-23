package uniquindio.seminario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaquinaVirtualDTO {
    private String id;
    private String nombre;
    private String ip;
    private String hostname;
    private Integer idUser;
    private String estado;
    private String tipoMV;
    private Integer idMF;

    public MaquinaVirtualDTO(String id, String nombre, String ip, String hostname, Integer idUser, String estado, String tipoMV, Integer idMF) {
        this.id = id;
        this.nombre = nombre;
        this.ip = ip;
        this.hostname = hostname;
        this.idUser = idUser;
        this.estado = estado;
        this.tipoMV = tipoMV;
        this.idMF = idMF;
    }
}


