package fr.meya.questconnect.toolkit.port.out;

public interface ICompetenceAdapter {

    String getCompetenceList();

    String createCompetence(Object competenceData);

    String updateCompetence(Long id, Object competenceData);

    String deleteCompetence(Long id);
}
