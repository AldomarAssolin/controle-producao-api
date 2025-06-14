// OrdemProducaoController
package online.aldomar.api.controller;

import online.aldomar.api.model.OrdemProducao;
import online.aldomar.api.service.OrdemProducaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ordens")
@RequiredArgsConstructor
public class OrdemProducaoController {

    private final OrdemProducaoService service;

    @GetMapping
    public List<OrdemProducao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrdemProducao findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemProducao create(@RequestBody OrdemProducao o) {
        return service.create(o);
    }

    @PutMapping("/{id}")
    public OrdemProducao update(@PathVariable Long id, @RequestBody OrdemProducao o) {
        return service.update(id, o);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
