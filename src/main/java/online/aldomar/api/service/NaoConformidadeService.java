// NaoConformidadeService
package online.aldomar.api.service;

import online.aldomar.api.model.NaoConformidade;
import online.aldomar.api.repository.NaoConformidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NaoConformidadeService {

    private final NaoConformidadeRepository repository;

    public List<NaoConformidade> findAll() {
        return repository.findAll();
    }

    public NaoConformidade findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NaoConformidade não encontrado com id " + id));
    }

    public NaoConformidade create(NaoConformidade naoConformidade) {
        return repository.save(naoConformidade);
    }

    public NaoConformidade update(Long id, NaoConformidade dados) {
        NaoConformidade s = findById(id);
        s.setDescricao(dados.getDescricao());
        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
