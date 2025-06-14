// EstoqueService
package online.aldomar.api.service;

import online.aldomar.api.model.Estoque;
import online.aldomar.api.repository.EstoqueRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final EstoqueRepository repository;

    public List<Estoque> findAll() { return repository.findAll(); }

    public Estoque findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estoque não encontrado com id " + id));
    }

    public Estoque create(Estoque estoque) { return repository.save(estoque); }
    
    public Estoque update(Long id, Estoque dados) {
        Estoque s = findById(id);
        s.setProduto(dados.getProduto());
        return repository.save(s);
    }

    public void delete(Long id) { repository.deleteById(id); }
}

