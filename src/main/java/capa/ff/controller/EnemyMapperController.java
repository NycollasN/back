package capa.ff.controller;



import capa.ff.DTO.EnemyMapDTO;
import capa.ff.service.EnemyMapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mapper")
public class EnemyMapperController {

    private final EnemyMapService enemyMapService;

    @Autowired
    public EnemyMapperController(EnemyMapService enemyMapService) {
        this.enemyMapService = enemyMapService;
    }

    @PostMapping("/anteban")
    public ResponseEntity<?> anteban(@RequestBody @Valid EnemyMapDTO enemyMapDTO) {
        try {
            String result = enemyMapService.anteban(enemyMapDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar anteban: " + e.getMessage());
        }
    }

    @PostMapping("/sync")
    public ResponseEntity<?> sincronizarCoordenadas(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok(Map.of(
                "status", "sincronizado",
                "intervaloMs", 100
        ));
    }

    @GetMapping("/radar-config")
    public ResponseEntity<?> obterConfiguracaoRadar() {
        return ResponseEntity.ok(Map.of(
                "raioMaximo", 200,
                "exibirDistancia", true,
                "corInimigo", "#FF0000"
        ));
    }
}