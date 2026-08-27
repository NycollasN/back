package capa.ff.service;

import capa.ff.entity.Usuario;
import capa.ff.Repository.UsuarioRepository;
import capa.ff.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider; // Injeta a classe correta do pacote security

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String autenticar(String username, String senha) {
        Optional<Usuario> userOpt = usuarioRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            Usuario usuario = userOpt.get();
            if (passwordEncoder.matches(senha, usuario.getSenha()) && usuario.isAtivo()) {
                // Chama o método de geração de token da sua classe JwtTokenProvider
                return jwtTokenProvider.generateToken(usuario.getUsername());
            }
        }
        return null;
    }
}