package fr.meya.questconnect.toolkit.port.out;

public interface ICompetenceAdapter {

    String getCompetenceList();

    String createCompetence(Object competenceData);

    String updateCompetence(String id, Object competenceData);

    String deleteCompetence(String id);
}
