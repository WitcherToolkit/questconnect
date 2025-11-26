package fr.meya.questconnect.toolkit.port.out;

public interface IProfessionAdapter {

    String getProfessionList();

    String getProfessionCompetences(String id);

    String createProfession(Object professionData);

    String updateProfession(String id, Object professionData);

    String deleteProfession(String id);
}
