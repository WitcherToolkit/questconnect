package fr.meya.questconnect.toolkit.port.out;

public interface IPersonnageAdapter {

    String getPersonnageById(String id);

    String createPersonnage(Object personnageData);
}
