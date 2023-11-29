package uniquindio.seminario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TipoMaquinaDTO {
    private Integer ramMB;
    private Integer cpu;
    private Integer storageGB;
}
