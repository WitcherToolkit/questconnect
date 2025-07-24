package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.port.out.IProfessionAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionService {
    @Autowired
    private IProfessionAdapter professionAdapter;

    public String getProfessionList() {
        return professionAdapter.getProfessionList();
    }

    public String getProfessionCompetences(Long id) {
        return professionAdapter.getProfessionCompetences(id);
    }
}
