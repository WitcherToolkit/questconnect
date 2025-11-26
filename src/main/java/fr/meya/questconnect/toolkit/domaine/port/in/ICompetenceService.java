package fr.meya.questconnect.toolkit.domaine.port.in;

public interface ICompetenceService {

    String getCompetenceList();

    String createCompetence(Object competenceData);

    String updateCompetence(String id, Object competenceData);

    String deleteCompetence(String id);

}
