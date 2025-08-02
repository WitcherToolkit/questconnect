package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.port.out.IEnvoutementAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvoutementService {

    @Autowired
    private IEnvoutementAdapter envoutementAdapter;

    public String getEnvoutementList(){
        return envoutementAdapter.getEnvoutementList();
    }

    public String updateEnvoutement(long id, Object envoutementData) {
        return envoutementAdapter.updateEnvoutement(id, envoutementData);
    }

}
