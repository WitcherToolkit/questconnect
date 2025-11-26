package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IPersonnageService {

    String getPersonnageById(String id);

    String createPersonnage(Object personnageData);
}
