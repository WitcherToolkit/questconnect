package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IMagieService {

    String getMagieList(String niveau);

    String createMagie(Object magieData);

    String updateMagie(String id, Object magieData);

    String deleteMagie(String id);

}
