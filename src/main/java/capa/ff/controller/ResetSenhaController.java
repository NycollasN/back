package capa.ff.controller;


import capa.ff.entity.Usuario;
import capa.ff.Repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class ResetSenhaController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public ResetSenhaController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/reset-admin")
    public ResponseEntity<String> resetAdmin() {
        Usuario admin = usuarioRepository.findByUsername("admin")
                .orElse(new Usuario());

        admin.setUsername("admin");
        admin.setSenha(passwordEncoder.encode("999000"));
        admin.setAtivo(true);

        usuarioRepository.save(admin);

        return ResponseEntity.ok("Senha do admin atualizada com sucesso para: 999000");
    }
}