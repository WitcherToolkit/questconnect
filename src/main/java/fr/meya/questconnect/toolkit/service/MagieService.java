package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.port.in.IMagieService;
import fr.meya.questconnect.toolkit.port.out.IMagieAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class MagieService implements IMagieService {

    @Autowired
    private IMagieAdapter magieAdapter;

    public String getMagieList(String niveau) {
        return magieAdapter.getMagieList(niveau);
    }

    public String createMagie(Object magieData) {
        return magieAdapter.createMagie(magieData);
    }

    public String updateMagie(String id, Object magieData) {
        return magieAdapter.updateMagie(id, magieData);
    }

    public String deleteMagie(String id) {
        return magieAdapter.deleteMagie(id);
    }

}
