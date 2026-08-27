package capa.ff.service;


import capa.ff.Repository.FreeFireUserRepository;
import capa.ff.entity.FreeFireUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FreeFireUserService {

    @Autowired
    private FreeFireUserRepository repository;

    public Optional<FreeFireUser> buscarPorPlayerKey(String playerKey) {
        return repository.findByPlayerKey(playerKey);
    }

    public boolean vincularHwid(String playerKey, String hwid) {
        Optional<FreeFireUser> userOpt = repository.findByPlayerKey(playerKey);
        if (userOpt.isPresent()) {
            FreeFireUser user = userOpt.get();
            if (user.getHwid() == null || user.getHwid().equals(hwid)) {
                user.setHwid(hwid);
                repository.save(user);
                return true;
            }
        }
        return false;
    }
}