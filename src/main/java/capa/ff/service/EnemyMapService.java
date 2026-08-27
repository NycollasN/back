package capa.ff.service;


import capa.ff.DTO.EnemyMapDTO;
import capa.ff.Repository.EnemyMapRepository;
import capa.ff.entity.EnemyMap;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnemyMapService {

    @Autowired
    private EnemyMapRepository repository;

    public EnemyMap obterConfiguracao() {
        return repository.findAll().stream().findFirst().orElseGet(() -> {
            EnemyMap defaultMap = new EnemyMap();
            return repository.save(defaultMap);
        });
    }

    public String anteban(EnemyMapDTO enemyMapDTO) {
        if (enemyMapDTO != null && enemyMapDTO.getNome() != null && enemyMapDTO.getNome().startsWith("ban")) {
            return "Anteban realizado com sucesso";
        }
        return "Falha no anteban";
    }
}
