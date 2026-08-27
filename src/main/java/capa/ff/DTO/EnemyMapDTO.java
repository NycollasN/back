package capa.ff.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;

@Data

@AllArgsConstructor
public class EnemyMapDTO {
    private int raioMaximo;
    private boolean exibirDistancia;
    private String corInimigo;

    private String nome;



    // Construtor com parâmetros
    public EnemyMapDTO(String nome) {
        this.nome = nome;
    }

    // Getter
    public String getNome() {
        return nome;
    }

    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
}