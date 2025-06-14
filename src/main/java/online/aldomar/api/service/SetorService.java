// SetorService
package online.aldomar.api.service;

import online.aldomar.api.model.Setor;
import online.aldomar.api.repository.SetorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository repository;

    public List<Setor> findAll() {
        return repository.findAll();
    }

    public Setor findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Setor não encontrado com id " + id));
    }

    public Setor create(Setor setor) {
        return repository.save(setor);
    }

    public Setor update(Long id, Setor dados) {
        Setor s = findById(id);
        s.setNome(dados.getNome());
        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
