package fr.meya.questconnect.toolkit.port.out;

public interface IRituelAdapter {

    String getRituelList();

    String updateRituel(Long id, Object rituelData);

}
