package capa.ff.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_enemy_map")
public class EnemyMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int raioMaximo = 200;
    private boolean exibirDistancia = true;
    private String corInimigo = "#FF0000";

    public EnemyMap() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getRaioMaximo() { return raioMaximo; }
    public void setRaioMaximo(int raioMaximo) { this.raioMaximo = raioMaximo; }

    public boolean isExibirDistancia() { return exibirDistancia; }
    public void setExibirDistancia(boolean exibirDistancia) { this.exibirDistancia = exibirDistancia; }

    public String getCorInimigo() { return corInimigo; }
    public void setCorInimigo(String corInimigo) { this.corInimigo = corInimigo; }
}

