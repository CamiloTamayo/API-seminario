package uniquindio.seminario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaquinaVirtualDTO {
    private Integer id;
    private String nombre;
    private String ip;
    private String hostname;
    private Integer idUser;
    private String contrasenia;
    private String estado;
    private String tipoMV;
    private Integer idMF;
    private Integer os;

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
}


