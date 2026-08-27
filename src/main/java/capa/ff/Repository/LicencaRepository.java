package capa.ff.Repository;



import capa.ff.entity.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Long> {
    Optional<Licenca> findByChave(String chave);
    boolean existsByChave(String chave);
}
