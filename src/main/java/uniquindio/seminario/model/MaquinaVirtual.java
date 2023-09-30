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
public class MaquinaVirtual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String ip;

    @Column(length = 50)
    private String hostname;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private MaquinaFisica mfisica;

    public MaquinaVirtual(Integer id, String nombre, String ip, String hostname, Usuario usuario, MaquinaFisica mfisica) {
        this.id = id;
        this.nombre = nombre;
        this.ip = ip;
        this.hostname = hostname;
        this.usuario = usuario;
        this.mfisica = mfisica;
    }
}
