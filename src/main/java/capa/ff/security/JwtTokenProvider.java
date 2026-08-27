package capa.ff.security;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${api.security.token.secret}")
    private String secretKey;

    @Value("${api.security.token.expiration-hours}")
    private long expirationHours;

    private final String SECRET_KEY = "suaChaveSecretaSuperSeguraParaOJWTDoPainelFF"; // Altere para sua chave
    private final long EXPIRATION_TIME = 86400000; // 24 horas em milissegundos

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String gerarToken(String username) {
        Date agora = new Date();
        Date dataExpiracao = new Date(agora.getTime() + (expirationHours * 3600000));

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(agora)
                .setExpiration(dataExpiracao)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes())
                .compact();
    }
}