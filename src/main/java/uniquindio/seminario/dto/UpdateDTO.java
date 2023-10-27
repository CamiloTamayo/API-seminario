package uniquindio.seminario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateDTO {
    private Integer id;
    private String estado;


    public UpdateDTO() {


    }
    public UpdateDTO(Integer id, String estado) {
        this.id = id;
        this.estado = estado;

    }


}
