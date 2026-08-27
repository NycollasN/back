package capa.ff.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ff/users")
public class FreeFireUserController {

    @GetMapping("/{playerKey}")
    public ResponseEntity<?> obterPerfilJogador(@PathVariable String playerKey) {
        return ResponseEntity.ok(Map.of(
                "playerKey", playerKey,
                "statusAcc", "ATIVO",
                "nivelAcesso", "PREMIUM"
        ));
    }

    @PostMapping("/vincular-hwid")
    public ResponseEntity<?> vincularHwid(@RequestBody Map<String, String> payload) {
        String playerKey = payload.get("playerKey");
        String hwid = payload.get("hwid");

        return ResponseEntity.ok(Map.of(
                "mensagem", "HWID vinculado com sucesso",
                "playerKey", playerKey,
                "hwid", hwid
        ));
    }
}
