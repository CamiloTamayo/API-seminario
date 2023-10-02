package uniquindio.seminario.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MaquinaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMF;

    @Column(length = 150)
    private String especs;

    @Column(length = 50)
    private String ip;

    @OneToMany(mappedBy = "mfisica")
    @ToString.Exclude
    private List<MaquinaVirtual> maquinas;

    public MaquinaFisica(Integer idMF, String especs, String ip) {

        this.idMF = idMF;
        this.especs =  especs;
        this.ip =  ip;
    }

}
