// NaoConformidadeController
package online.aldomar.api.controller;

import online.aldomar.api.model.NaoConformidade;
import online.aldomar.api.service.NaoConformidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/nao-conformidades")
@RequiredArgsConstructor
public class NaoConformidadeController {

    private final NaoConformidadeService service;

    @GetMapping
    public List<NaoConformidade> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public NaoConformidade findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NaoConformidade create(@RequestBody NaoConformidade n) {
        return service.create(n);
    }

    @PutMapping("/{id}")
    public NaoConformidade update(@PathVariable Long id, @RequestBody NaoConformidade n) {
        return service.update(id, n);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
