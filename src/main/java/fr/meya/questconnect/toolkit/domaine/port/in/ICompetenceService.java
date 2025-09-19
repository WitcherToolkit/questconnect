package fr.meya.questconnect.toolkit.domaine.port.in;

public interface ICompetenceService {

    String getCompetenceList();

    String createCompetence(Object competenceData);

    String updateCompetence(long id, Object competenceData);

    String deleteCompetence(long id);

}
