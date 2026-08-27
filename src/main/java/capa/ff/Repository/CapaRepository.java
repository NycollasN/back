package capa.ff.Repository;



import capa.ff.entity.Capa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapaRepository extends JpaRepository<Capa, Long> {
}
