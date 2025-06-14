// EtiquetaQrController
package online.aldomar.api.controller;

import online.aldomar.api.model.EtiquetaQr;
import online.aldomar.api.service.EtiquetaQrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etiquetas-qr")
@RequiredArgsConstructor
public class EtiquetaQrController {

    private final EtiquetaQrService service;

    @GetMapping
    public List<EtiquetaQr> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EtiquetaQr findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EtiquetaQr create(@RequestBody EtiquetaQr e) {
        return service.create(e);
    }

    @PutMapping("/{id}")
    public EtiquetaQr update(@PathVariable Long id, @RequestBody EtiquetaQr e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
