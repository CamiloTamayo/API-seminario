package uniquindio.seminario.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(length = 500)
    private String contrasenia;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private MaquinaFisica mfisica;

    @Column(length = 50)
    private String estado;

    @ManyToOne
    private TipoMaquina tipoMaquina;

    @ManyToOne
    private SistemaOperativo sistemaOperativo;

    public MaquinaVirtual(Integer id, String nombre, String ip, String hostname, String contrasenia, Usuario usuario, MaquinaFisica mfisica, TipoMaquina tipoMaquina, String estado, SistemaOperativo sistemaOperativo) {
        this.id = id;
        this.nombre = nombre;
        this.ip = ip;
        this.hostname = hostname;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.mfisica = mfisica;
        this.estado = estado;
        this.tipoMaquina = tipoMaquina;
        this.sistemaOperativo = sistemaOperativo;
    }
}
