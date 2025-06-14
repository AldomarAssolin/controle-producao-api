// HistoricoProducaoService
package online.aldomar.api.service;

import online.aldomar.api.model.HistoricoProducao;
import online.aldomar.api.model.Operador;
import online.aldomar.api.model.OrdemProducao;
import online.aldomar.api.repository.HistoricoProducaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricoProducaoService {

    private final HistoricoProducaoRepository repository;

    public List<HistoricoProducao> findAll() {
        return repository.findAll();
    }

    public HistoricoProducao findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HistoricoProducao não encontrado com id " + id));
    }

    public HistoricoProducao create(
            OrdemProducao ordem,
            String statusAnterior,
            String statusNovo,
            Operador alteradoPor
    ) {
        var h = new HistoricoProducao();
        h.setOrdem(ordem);
        h.setStatusAnterior(statusAnterior);
        h.setStatusNovo(statusNovo);
        h.setAlteradoPor(alteradoPor);
        return repository.save(h);
    }

    public HistoricoProducao update(Long id, HistoricoProducao dados) {
        HistoricoProducao s = findById(id);
        s.setStatusNovo(dados.getStatusNovo());
        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
