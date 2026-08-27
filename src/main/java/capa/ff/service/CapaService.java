package capa.ff.service;


import capa.ff.Repository.CapaRepository;
import capa.ff.entity.Capa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapaService {

    @Autowired
    private CapaRepository repository;


    @Autowired
    private CapaRepository capaRepository;

    /**
     * Retorna a primeira configuração de sensibilidade/capa do banco
     * ou cria uma padrão caso ainda não exista.
     */
    public Capa obterSensibilidade() {
        return capaRepository.findAll()
                .stream()
                .findFirst()
                .orElseGet(() -> {
                    Capa defaultCapa = new Capa();
                    return capaRepository.save(defaultCapa);
                });
    }

    /**
     * Salva ou atualiza a configuração de capa/sensibilidade
     */
    public Capa salvarSensibilidade(Capa capa) {
        return capaRepository.save(capa);
    }

    public Capa obterConfiguracaoAtual() {
        return repository.findAll().stream().findFirst().orElseGet(() -> {
            Capa defaultCapa = new Capa();
            return repository.save(defaultCapa);
        });
    }

    public Capa salvar(Capa capa) {
        return repository.save(capa);
    }
}
