// HistoricoProducaoController
package online.aldomar.api.controller;

import online.aldomar.api.model.HistoricoProducao;
import online.aldomar.api.service.HistoricoProducaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historicos")
@RequiredArgsConstructor
public class HistoricoProducaoController {

    private final HistoricoProducaoService service;

    @GetMapping
    public List<HistoricoProducao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public HistoricoProducao findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HistoricoProducao create(@RequestBody HistoricoProducao h) {
        return service.create(
                h.getOrdem(),
                h.getStatusAnterior(),
                h.getStatusNovo(),
                h.getAlteradoPor()
        );
    }

    @PutMapping("/{id}")
    public HistoricoProducao update(@PathVariable Long id, @RequestBody HistoricoProducao h) {
        return service.update(id, h);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
