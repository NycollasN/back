package capa.ff.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/licencas")
public class LicencaController {

    @PostMapping("/gerar")
    public ResponseEntity<?> gerarLicenca(@RequestParam int diasValidade) {
        String chave = UUID.randomUUID().toString().toUpperCase();
        return ResponseEntity.ok(Map.of(
                "chave", chave,
                "diasValidade", diasValidade,
                "status", "CRIADA"
        ));
    }

    @PostMapping("/validar")
    public ResponseEntity<?> validarLicenca(@RequestBody Map<String, String> body) {
        String chave = body.get("chave");
        // Lógica de validação no banco
        return ResponseEntity.ok(Map.of("chave", chave, "valida", true));
    }
}