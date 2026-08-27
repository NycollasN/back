package capa.ff.controller;

import capa.ff.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtTokenProvider tokenProvider
    ) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody Map<String, String> dados
    ) {

        try {

            String username = dados.get("username");

            String senha = dados.containsKey("senha")
                    ? dados.get("senha")
                    : dados.get("password");

            System.out.println(
                    "Tentativa de login com usuario: " + username
            );

            if (username == null || username.isBlank()) {
                return ResponseEntity.badRequest()
                        .body("Username é obrigatório");
            }

            if (senha == null || senha.isBlank()) {
                return ResponseEntity.badRequest()
                        .body("Senha é obrigatória");
            }

            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    username,
                                    senha
                            )
                    );

            String token =
                    tokenProvider.gerarToken(
                            authentication.getName()
                    );

            return ResponseEntity.ok(
                    Map.of(
                            "token", token,
                            "username", authentication.getName()
                    )
            );

        } catch (Exception e) {

            System.err.println(
                    "ERRO DE AUTENTICAÇÃO: " + e.getMessage()
            );

            return ResponseEntity
                    .status(401)
                    .body("Usuário ou senha inválidos");
        }
    }
}