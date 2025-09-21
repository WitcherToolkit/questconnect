package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IPersonnageService {

    String getPersonnageById(Long id);

    String createPersonnage(Object personnageData);
}
