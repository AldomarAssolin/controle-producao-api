package online.aldomar.api.controller;

import online.aldomar.api.model.Funcao;
import online.aldomar.api.service.FuncaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/funcoes")
@RequiredArgsConstructor
public class FuncaoController {

    private final FuncaoService service;

    @GetMapping
    public List<Funcao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Funcao findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcao create(@RequestBody Funcao f) {
        return service.create(f);
    }

    @PutMapping("/{id}")
    public Funcao update(@PathVariable Long id, @RequestBody Funcao f) {
        return service.update(id, f);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
