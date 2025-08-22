package fr.meya.questconnect.toolkit.port.out;

public interface IProfessionAdapter {

    String getProfessionList();

    String getProfessionCompetences(Long id);

    String createProfession(Object professionData);

    String updateProfession(Long id, Object professionData);

    String deleteProfession(Long id);
}
