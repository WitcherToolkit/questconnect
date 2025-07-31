package fr.meya.questconnect.toolkit.port.out;

public interface IMagieAdapter {
    String getMagieList();
    String updateMagie(Long id, Object magieData);
}
