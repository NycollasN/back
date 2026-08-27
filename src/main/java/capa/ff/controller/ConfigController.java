package capa.ff.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/config")
@CrossOrigin(origins = "*")
public class ConfigController {

    @GetMapping
    public ResponseEntity<?> obterConfiguracoes() {
        return ResponseEntity.ok(Map.of(
                "versao", "1.0.0",
                "manutencao", false,
                "servidorAtivo", true
        ));
    }

    @PutMapping
    public ResponseEntity<?> atualizarConfiguracoes(@RequestBody Map<String, Object> configs) {
        return ResponseEntity.ok(Map.of("mensagem", "Configurações atualizadas com sucesso", "dados", configs));
    }

    // Endpoint esperado pelo frontend ao clicar na Sensibilidade
    @PostMapping("/sensibilidade")
    public ResponseEntity<?> salvarSensibilidade(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok(Map.of("mensagem", "Sensibilidade atualizada com sucesso", "dados", payload));
    }
}
