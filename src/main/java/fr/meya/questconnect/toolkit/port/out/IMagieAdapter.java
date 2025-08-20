package fr.meya.questconnect.toolkit.port.out;

public interface IMagieAdapter {

    String getMagieList();

    String createMagie(Object magieData);

    String updateMagie(Long id, Object magieData);

    String deleteMagie(Long id);

}
