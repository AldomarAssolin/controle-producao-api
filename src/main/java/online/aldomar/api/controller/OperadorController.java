// OperadorController
package online.aldomar.api.controller;

import online.aldomar.api.model.Operador;
import online.aldomar.api.service.OperadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/operadores")
@RequiredArgsConstructor
public class OperadorController {

    private final OperadorService service;

    @GetMapping
    public List<Operador> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Operador findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Operador create(@RequestBody Operador o) {

        return service.create(o);
    }

    @PutMapping("/{id}")
    public Operador update(@PathVariable Long id, @RequestBody Operador o) {
        return service.update(id, o);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
