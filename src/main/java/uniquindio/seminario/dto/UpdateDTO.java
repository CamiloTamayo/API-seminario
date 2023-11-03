package uniquindio.seminario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateDTO {
    private Integer id;
    private String cambio;


    public UpdateDTO() {


    }
    public UpdateDTO(Integer id, String cambio) {
        this.id = id;
        this.cambio = cambio;

    }


}
