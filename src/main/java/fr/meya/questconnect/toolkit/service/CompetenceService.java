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

    public String createCompetence(Object competenceData) {
        return competenceAdapter.createCompetence(competenceData);
    }

    public String updateCompetence(long id, Object competenceData) {
        return competenceAdapter.updateCompetence(id, competenceData);
    }

    public String deleteCompetence(long id) {
        return competenceAdapter.deleteCompetence(id);
    }

}
