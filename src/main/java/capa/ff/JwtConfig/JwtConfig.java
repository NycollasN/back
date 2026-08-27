package capa.ff.JwtConfig;



import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class JwtConfig {

    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${api.security.token.expiration-hours}")
    private Long expirationHours;
}