package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IProfessionService {

    String getProfessionList();

    String getProfessionCompetences(Long id);

    String createProfession(Object professionData);

    String updateProfession(long id, Object professionData);

    String deleteProfession(long id);

}
