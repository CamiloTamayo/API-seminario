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
    private String contrasenia;
    private String estado;
    private Integer tipoMV;
    private Integer idMF;

    @Override
    public String toString() {
        return "MaquinaVirtualDTO{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ip='" + ip + '\'' +
                ", hostname='" + hostname + '\'' +
                ", idUser=" + idUser +
                ", estado='" + estado + '\'' +
                ", tipoMV='" + tipoMV + '\'' +
                ", idMF=" + idMF +
                '}';
    }

    public MaquinaVirtualDTO(String id, String nombre, String ip, String hostname, Integer idUser, String contrasenia, String estado, Integer tipoMV, Integer idMF) {
        this.id = id;
        this.nombre = nombre;
        this.ip = ip;
        this.hostname = hostname;
        this.idUser = idUser;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.tipoMV = tipoMV;
        this.idMF = idMF;
    }
}


