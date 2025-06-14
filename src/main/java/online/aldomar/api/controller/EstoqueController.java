// EstoqueController
package online.aldomar.api.controller;

import online.aldomar.api.model.Estoque;
import online.aldomar.api.service.EstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estoques")
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService service;

    @GetMapping
    public List<Estoque> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Estoque findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estoque create(@RequestBody Estoque e) {
        return service.create(e);
    }

    @PutMapping("/{id}")
    public Estoque update(@PathVariable Long id, @RequestBody Estoque e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
