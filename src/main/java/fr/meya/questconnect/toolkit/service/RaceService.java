package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.port.in.IRaceService;
import fr.meya.questconnect.toolkit.port.out.IRaceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService implements IRaceService {

    @Autowired
    private IRaceAdapter raceAdapter;

    public String getRaceList(){
        return raceAdapter.getRaceList();
    }

    public String getRaceById(String id){
        return raceAdapter.getRaceById(id);
    }

    public String createRace(Object raceData) {
        return raceAdapter.createRace(raceData);
    }

    public String updateRace(String id, Object raceData) {
        return raceAdapter.updateRace(id, raceData);
    }

    public String deleteRace(String id) {
        return raceAdapter.deleteRace(id);
    }
}
