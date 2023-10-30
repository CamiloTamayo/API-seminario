package uniquindio.seminario.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaquinaFisicaDTO {

    private Integer id;
    private String adaptador;
    private Integer cpu;
    private String hostname;
    private String ip;
    private String os;
    private Integer ram;
    private Integer almacenamiento;
}
