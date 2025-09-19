package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.port.in.IProfessionService;
import fr.meya.questconnect.toolkit.port.out.IProfessionAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionService implements IProfessionService {
    @Autowired
    private IProfessionAdapter professionAdapter;

    public String getProfessionList() {
        return professionAdapter.getProfessionList();
    }

    public String getProfessionCompetences(Long id) {
        return professionAdapter.getProfessionCompetences(id);
    }

    public String createProfession(Object professionData) {
        return professionAdapter.createProfession(professionData);
    }

    public String updateProfession (long id, Object raceData) {
        return professionAdapter.updateProfession (id, raceData);
    }

    public String deleteProfession(long id) {
        return professionAdapter.deleteProfession(id);
    }
}
