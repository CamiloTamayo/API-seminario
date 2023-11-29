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
public class SistemaOperativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String hostname;

    @OneToMany(mappedBy = "sistemaOperativo")
    @ToString.Exclude
    @JsonIgnore
    private List<MaquinaVirtual> maquinas;
}
