package capa.ff.Repository;



import capa.ff.entity.FreeFireUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FreeFireUserRepository extends JpaRepository<FreeFireUser, Long> {
    Optional<FreeFireUser> findByPlayerKey(String playerKey);
    Optional<FreeFireUser> findByHwid(String hwid);
}