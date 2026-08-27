package capa.ff.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "tb_config_cliente")
public class ConfigCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String versaoApp;
    private boolean manutencao = false;
    private int limiteDispositivos = 1;

    public ConfigCliente() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVersaoApp() { return versaoApp; }
    public void setVersaoApp(String versaoApp) { this.versaoApp = versaoApp; }

    public boolean isManutencao() { return manutencao; }
    public void setManutencao(boolean manutencao) { this.manutencao = manutencao; }

    public int getLimiteDispositivos() { return limiteDispositivos; }
    public void setLimiteDispositivos(int limiteDispositivos) { this.limiteDispositivos = limiteDispositivos; }
}