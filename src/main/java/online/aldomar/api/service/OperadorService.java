// Exemplo para OperadorService
package online.aldomar.api.service;

import online.aldomar.api.model.Operador;
import online.aldomar.api.repository.OperadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperadorService {

    private final OperadorRepository repository;

    public List<Operador> findAll() {
        return repository.findAll();
    }

    public Operador findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Operador não encontrada com id " + id));
    }

    public Operador create(Operador operador) {
        return repository.save(operador);
    }

    public Operador update(Long id, Operador dados) {
        Operador f = findById(id);
        f.setNome(dados.getNome());
        return repository.save(f);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
