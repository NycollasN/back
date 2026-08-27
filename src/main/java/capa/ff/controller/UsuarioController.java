package capa.ff.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(List.of(
                Map.of("id", 1, "username", "admin", "ativo", true),
                Map.of("id", 2, "username", "usuario1", "ativo", true)
        ));
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Map<String, String> usuario) {
        return ResponseEntity.status(201).body(Map.of(
                "mensagem", "Usuário criado com sucesso",
                "username", usuario.get("username")
        ));
    }
}