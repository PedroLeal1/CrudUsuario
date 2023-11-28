package Controller;

import Model.Usuario;
import Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        usuario = service.salvar(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultarPorId(@PathVariable int id){
        Usuario usuario = service.consultarPorId(id);
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        if(service.excluir(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}