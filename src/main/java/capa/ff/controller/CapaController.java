package capa.ff.controller;




import capa.ff.entity.Capa;
import capa.ff.service.CapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/capa")
public class CapaController {

    @Autowired
    private CapaService capaService;

    @GetMapping("/sensibilidade")
    public ResponseEntity<Capa> obterSensibilidade() {
        Capa capa = capaService.obterSensibilidade();
        return ResponseEntity.ok(capa);
    }

    @PostMapping("/sensibilidade/salvar")
    public ResponseEntity<Capa> salvarSensibilidade(@RequestBody Capa capa) {
        Capa capaSalva = capaService.salvarSensibilidade(capa);
        return ResponseEntity.ok(capaSalva);
    }
}