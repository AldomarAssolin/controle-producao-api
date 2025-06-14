// EtiquetaQrService
package online.aldomar.api.service;

import online.aldomar.api.model.EtiquetaQr;
import online.aldomar.api.repository.EtiquetaQrRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtiquetaQrService {

    private final EtiquetaQrRepository repository;

    public List<EtiquetaQr> findAll() {
        return repository.findAll();
    }

    public EtiquetaQr findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EtiquetaQr não encontrado com id " + id));
    }

    public EtiquetaQr create(EtiquetaQr etiquetaQr) {
        return repository.save(etiquetaQr);
    }

    public EtiquetaQr update(Long id, EtiquetaQr dados) {
        EtiquetaQr s = findById(id);
        s.setCodigo(dados.getCodigo());
        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
