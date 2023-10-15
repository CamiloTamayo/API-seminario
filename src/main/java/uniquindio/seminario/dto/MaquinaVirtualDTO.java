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
    String estado;
    String hostname;
    String ip;
    String nombre;
    Integer idMF;
    Integer idUser;
    Integer tipoMV;

}


