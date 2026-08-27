package capa.ff.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeFireUserDTO {
    private String playerKey;
    private String hwid;
    private String nivelAcesso;
}