package capa.ff.Repository;



import capa.ff.entity.ConfigCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigClienteRepository extends JpaRepository<ConfigCliente, Long> {
}