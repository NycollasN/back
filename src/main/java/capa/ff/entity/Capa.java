package capa.ff.entity;



import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_capa")
public class Capa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int geral = 95;
    private int redDot = 90;
    private int mira2x = 85;
    private int mira4x = 80;
    private int suavizacao = 5;

    // Construtores
    public Capa() {}

    public Capa(int geral, int redDot, int mira2x, int mira4x, int suavizacao) {
        this.geral = geral;
        this.redDot = redDot;
        this.mira2x = mira2x;
        this.mira4x = mira4x;
        this.suavizacao = suavizacao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getGeral() { return geral; }
    public void setGeral(int geral) { this.geral = geral; }

    public int getRedDot() { return redDot; }
    public void setRedDot(int redDot) { this.redDot = redDot; }

    public int getMira2x() { return mira2x; }
    public void setMira2x(int mira2x) { this.mira2x = mira2x; }

    public int getMira4x() { return mira4x; }
    public void setMira4x(int mira4x) { this.mira4x = mira4x; }

    public int getSuavizacao() { return suavizacao; }
    public void setSuavizacao(int suavizacao) { this.suavizacao = suavizacao; }

    // Métodos equals, hashCode e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Capa)) return false;
        Capa capa = (Capa) o;
        return Objects.equals(id, capa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Capa{" +
                "id=" + id +
                ", geral=" + geral +
                ", redDot=" + redDot +
                ", mira2x=" + mira2x +
                ", mira4x=" + mira4x +
                ", suavizacao=" + suavizacao +
                '}';
    }
}