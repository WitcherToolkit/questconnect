package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.port.out.ICompetenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService {
    @Autowired
    private ICompetenceAdapter competenceAdapter;

    public String getCompetenceList() {
        return competenceAdapter.getCompetenceList();
    }
}
