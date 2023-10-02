package uniquindio.seminario.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = false)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String correo;

    @Column(length = 50)
    private String contrasenia;

    @ManyToOne
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<MaquinaVirtual> maquinasVirtuales;

    public Usuario(int id, String nombre, String correo, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
}
