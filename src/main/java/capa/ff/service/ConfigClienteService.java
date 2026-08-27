package capa.ff.service;


import capa.ff.Repository.ConfigClienteRepository;
import capa.ff.entity.ConfigCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigClienteService {

    @Autowired
    private ConfigClienteRepository configClienteRepository;

    public ConfigCliente obterOuCriarPadrao() {
        return configClienteRepository.findAll().stream().findFirst().orElseGet(() -> {
            ConfigCliente config = new ConfigCliente();
            config.setVersaoApp("1.0.0");
            config.setManutencao(false);
            return configClienteRepository.save(config);
        });
    }

    public ConfigCliente atualizar(ConfigCliente novaConfig) {
        return configClienteRepository.save(novaConfig);
    }
}