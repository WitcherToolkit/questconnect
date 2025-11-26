package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.port.in.IRituelService;
import fr.meya.questconnect.toolkit.port.out.IRituelAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RituelService implements IRituelService {

    @Autowired
    private IRituelAdapter rituelAdapter;

    public String getRituelList() {
        return rituelAdapter.getRituelList();
    }

    public String createRituel(Object rituelData) {
        return rituelAdapter.createRituel(rituelData);
    }

    public String updateRituel(String id, Object rituelData) {
        return rituelAdapter.updateRituel(id, rituelData);
    }

    public String deleteRituel(String id) {
        return rituelAdapter.deleteRituel(id);
    }

}
