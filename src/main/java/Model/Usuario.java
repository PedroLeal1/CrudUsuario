package Model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private Integer id;


    private String nome;


    private String email;
}