package fr.meya.questconnect.toolkit.port.out;

public interface IMagieAdapter {

    String getMagieList(String niveau);

    String createMagie(Object magieData);

    String updateMagie(String id, Object magieData);

    String deleteMagie(String id);

}
