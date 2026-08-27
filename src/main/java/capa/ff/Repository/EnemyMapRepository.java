package capa.ff.Repository;


import capa.ff.entity.EnemyMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyMapRepository extends JpaRepository<EnemyMap, Long> {
}
