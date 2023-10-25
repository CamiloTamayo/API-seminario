package uniquindio.seminario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoMaquina {

    @Column(length = 50)
    private Integer idMF;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private Integer ramMB;

    @Column(length = 50)
    private Integer cpu;

    @Column(length = 50)
    private Integer storageGB;

    @Column(length = 50)
    private String hostname;

    @Column(length = 50)
    private String sistemaOperativo;


    @Column(length = 50)
    private String adapter;

    @OneToMany(mappedBy = "tipoMaquina")
    @ToString.Exclude
    @JsonIgnore
    private List<MaquinaVirtual> maquinas;
}
