package capa.ff.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "tb_ff_users")
public class FreeFireUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_key", unique = true, nullable = false)
    private String playerKey;

    private String hwid;
    private String nivelAcesso;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public FreeFireUser() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlayerKey() { return playerKey; }
    public void setPlayerKey(String playerKey) { this.playerKey = playerKey; }

    public String getHwid() { return hwid; }
    public void setHwid(String hwid) { this.hwid = hwid; }

    public String getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}