// SetorController
package online.aldomar.api.controller;

import online.aldomar.api.model.Setor;
import online.aldomar.api.service.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/setores")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService service;

    @GetMapping
    public List<Setor> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Setor findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Setor create(@RequestBody Setor s) {
        return service.create(s);
    }

    @PutMapping("/{id}")
    public Setor update(@PathVariable Long id, @RequestBody Setor s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
