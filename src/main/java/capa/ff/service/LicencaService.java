package capa.ff.service;


import capa.ff.Repository.LicencaRepository;
import capa.ff.entity.Licenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class LicencaService {

    @Autowired
    private LicencaRepository licencaRepository;

    public Licenca gerarLicenca(int diasValidade) {
        Licenca licenca = new Licenca();
        licenca.setChave(UUID.randomUUID().toString().toUpperCase());
        licenca.setDataExpiracao(LocalDateTime.now().plusDays(diasValidade));
        licenca.setExpirada(false);
        return licencaRepository.save(licenca);
    }

    public boolean validarLicenca(String chave) {
        Optional<Licenca> licencaOpt = licencaRepository.findByChave(chave);
        if (licencaOpt.isPresent()) {
            Licenca licenca = licencaOpt.get();
            if (licenca.getDataExpiracao().isAfter(LocalDateTime.now()) && !licenca.isExpirada()) {
                return true;
            }
        }
        return false;
    }
}