// Exemplo para FuncaoService
package online.aldomar.api.service;

import online.aldomar.api.model.Funcao;
import online.aldomar.api.repository.FuncaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncaoService {
    private final FuncaoRepository repository;

    public List<Funcao> findAll() {
        return repository.findAll();
    }

    public Funcao findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Função não encontrada com id " + id));
    }

    public Funcao create(Funcao funcao) {
        return repository.save(funcao);
    }

    public Funcao update(Long id, Funcao dados) {
        Funcao f = findById(id);
        f.setNome(dados.getNome());
        return repository.save(f);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

