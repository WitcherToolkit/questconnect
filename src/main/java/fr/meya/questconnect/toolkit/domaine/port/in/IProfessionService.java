package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IProfessionService {

    String getProfessionList();

    String getProfessionCompetences(String id);

    String createProfession(Object professionData);

    String updateProfession(String id, Object professionData);

    String deleteProfession(String id);

}
