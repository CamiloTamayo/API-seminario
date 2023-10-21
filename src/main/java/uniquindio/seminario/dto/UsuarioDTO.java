package uniquindio.seminario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String correo;
    private String apellidos;
    private String contrasenia;
    private String token;

    public UsuarioDTO(Integer id, String nombre, String correo, String apellidos, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
    }
}
