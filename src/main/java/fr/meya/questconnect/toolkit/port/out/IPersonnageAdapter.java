package fr.meya.questconnect.toolkit.port.out;

public interface IPersonnageAdapter {

    String getPersonnageById(Long id);

    String createPersonnage(Object personnageData);
}
