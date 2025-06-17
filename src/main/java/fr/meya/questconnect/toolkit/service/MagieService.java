package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.port.out.IMagieAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class MagieService {

    @Autowired
    private IMagieAdapter magieAdapter;

    @GetMapping
    public String getMagieList(){
        return magieAdapter.getMagieList();
    }
}
