// EtapaProducaoService
package online.aldomar.api.service;

import online.aldomar.api.model.EtapaProducao;
import online.aldomar.api.repository.EtapaProducaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EtapaProducaoService {

    private final EtapaProducaoRepository repository;
    private final HistoricoProducaoService historicoService;

    public List<EtapaProducao> findAll() {
        return repository.findAll();
    }

    public EtapaProducao findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EtapaProducao não encontrado com id " + id));
    }

    public EtapaProducao create(EtapaProducao etapaProducao) {
        return repository.save(etapaProducao);
    }

    public EtapaProducao update(Long id, EtapaProducao dados) {
        EtapaProducao s = findById(id);
        s.setStatus(dados.getStatus());
        return repository.save(s);
    }

    @Transactional
    public EtapaProducao updateStatus(Long id, String novoStatus) {
        var etapa = findById(id);
        var old = etapa.getStatus();
        etapa.setStatus(novoStatus);
        var updated = repository.save(etapa);
        historicoService.create(
                updated.getOrdem(),
                old,
                novoStatus,
                updated.getOperador()
        );
        return updated;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
