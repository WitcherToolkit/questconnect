package fr.meya.questconnect.toolkit.port.out;

public interface ICompetenceAdapter {

    String getCompetenceList();

    String updateCompetence(Long id, Object competenceData);
}
