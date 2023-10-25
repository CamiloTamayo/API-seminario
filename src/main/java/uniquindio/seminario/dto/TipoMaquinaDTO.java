package uniquindio.seminario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class TipoMaquinaDTO {

    private Integer idMF;
    private Integer id;
    private String nombre;
    private Integer ramMB;
    private Integer cpu;
    private Integer storageGB;
    private String hostname;
    private String sistemaOperativo;
    private String adapter;

    public TipoMaquinaDTO(Integer idMF, Integer id, String nombre, Integer ramMB, Integer cpu, Integer storageGB, String hostname, String sistemaOperativo) {
        this.idMF = idMF;
        this.id = id;
        this.nombre = nombre;
        this.ramMB = ramMB;
        this.cpu = cpu;
        this.storageGB = storageGB;
        this.hostname = hostname;
        this.sistemaOperativo = sistemaOperativo;
    }
}
