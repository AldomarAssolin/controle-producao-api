// OrdemProducaoService
package online.aldomar.api.service;

import online.aldomar.api.model.OrdemProducao;
import online.aldomar.api.repository.OrdemProducaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdemProducaoService {

    private final OrdemProducaoRepository repository;
    private final HistoricoProducaoService historicoService;

    public List<OrdemProducao> findAll() {
        return repository.findAll();
    }

    public OrdemProducao findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OrdemProducao não encontrado com id " + id));
    }

    @Transactional
    public OrdemProducao create(OrdemProducao dados) {
        // 1) salva a ordem
        var op = repository.save(dados);
        // 2) registra o histórico de criação
        historicoService.create(op, null, op.getStatus(), /* quem alterou? */ null);
        return op;
    }

    @Transactional
    public OrdemProducao update(Long id, OrdemProducao dados) {
        var op = findById(id);
        String old = op.getStatus();
        op.setStatus(dados.getStatus());
        var updated = repository.save(op);
        historicoService.create(op, old, updated.getStatus(), /* quem alterou? */ null);
        return updated;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
