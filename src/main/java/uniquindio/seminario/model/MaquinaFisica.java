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

    @Column(length = 50)
    private String ip;

    @Column(length = 50)
    private Integer ramMB;

    @Column(length = 50)
    private Integer cpu;

    @Column(length = 50)
    private Integer storageGB;

    @Column(length = 50)
    private String hostname;

    @Column(length = 50)
    private String os;

    @Column(length = 100)
    private String bridgeAdapter;

    @OneToMany(mappedBy = "mfisica")
    @ToString.Exclude
    private List<MaquinaVirtual> maquinas;

    public MaquinaFisica(String ip, Integer ramMB, Integer cpu, Integer storageGB, String hostname, String os, String bridgeAdapter, List<MaquinaVirtual> maquinas) {
        this.ip = ip;
        this.ramMB = ramMB;
        this.cpu = cpu;
        this.storageGB = storageGB;
        this.hostname = hostname;
        this.os = os;
        this.bridgeAdapter = bridgeAdapter;
        this.maquinas = maquinas;
    }
}
