package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.port.in.IEnvoutementService;
import fr.meya.questconnect.toolkit.port.out.IEnvoutementAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvoutementService implements IEnvoutementService {

    @Autowired
    private IEnvoutementAdapter envoutementAdapter;

    public String getEnvoutementList(){
        return envoutementAdapter.getEnvoutementList();
    }

    public String createEnvoutement(Object envoutementData) {
        return envoutementAdapter.createEnvoutement(envoutementData);
    }

    public String updateEnvoutement(String id, Object envoutementData) {
        return envoutementAdapter.updateEnvoutement(id, envoutementData);
    }

    public String deleteEnvoutement(String id) {
        return envoutementAdapter.deleteEnvoutement(id);
    }

}
