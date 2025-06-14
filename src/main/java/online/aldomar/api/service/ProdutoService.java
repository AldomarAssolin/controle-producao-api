// SetorService
package online.aldomar.api.service;

import online.aldomar.api.model.Produto;
import online.aldomar.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com id " + id));
    }

    public Produto create(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Long id, Produto dados) {
        Produto s = findById(id);
        s.setNome(dados.getNome());
        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
