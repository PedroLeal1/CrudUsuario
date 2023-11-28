package Service;

import Model.Usuario;
import Repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }

    public List<Usuario> listar(){
        return repository.findAll();
    }

    public Usuario consultarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

}
