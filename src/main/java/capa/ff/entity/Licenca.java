package capa.ff.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_licencas")
public class Licenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 64)
    private String chave;

    @Column(name = "data_expiracao", nullable = false)
    private LocalDateTime dataExpiracao;

    private boolean expirada = false;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Licenca() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getChave() { return chave; }
    public void setChave(String chave) { this.chave = chave; }

    public LocalDateTime getDataExpiracao() { return dataExpiracao; }
    public void setDataExpiracao(LocalDateTime dataExpiracao) { this.dataExpiracao = dataExpiracao; }

    public boolean isExpirada() { return expirada; }
    public void setExpirada(boolean expirada) { this.expirada = expirada; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}