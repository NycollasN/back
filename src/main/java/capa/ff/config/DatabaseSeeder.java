package capa.ff.config;

import capa.ff.Repository.UsuarioRepository;
import capa.ff.entity.Role;
import capa.ff.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Busca o usuário existente ou cria um novo se não achar
        Usuario admin = usuarioRepository.findByUsername("admin")
                .orElse(new Usuario());

        admin.setUsername("admin");
        // Força o re-encoding da senha pelo PasswordEncoder oficial do projeto
        admin.setSenha(passwordEncoder.encode("999000"));
        admin.setPerfil(Role.ADMIN);
        admin.setAtivo(true);

        usuarioRepository.save(admin);
        System.out.println("=== USUÁRIO ADMIN RECONFIGURADO COM SUCESSO ===");
    }
}