// EtapaProducaoController
package online.aldomar.api.controller;

import online.aldomar.api.model.EtapaProducao;
import online.aldomar.api.service.EtapaProducaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etapas")
@RequiredArgsConstructor
public class EtapaProducaoController {

    private final EtapaProducaoService service;

    @GetMapping
    public List<EtapaProducao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EtapaProducao findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EtapaProducao create(@RequestBody EtapaProducao e) {
        return service.create(e);
    }

    @PutMapping("/{id}")
    public EtapaProducao update(@PathVariable Long id, @RequestBody EtapaProducao e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
