package uniquindio.seminario.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MaquinaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String idMF;

    @Column(length = 150)
    private String especs;

    @Column(length = 50)
    private String ip;

    public MaquinaFisica(String idMF, String especs, String ip) {

        this.idMF = idMF;
        this.especs =  especs;
        this.ip =  ip;
    }

}
