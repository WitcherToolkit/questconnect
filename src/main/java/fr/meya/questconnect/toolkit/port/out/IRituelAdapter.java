package fr.meya.questconnect.toolkit.port.out;

public interface IRituelAdapter {

    String getRituelList();

    String createRituel(Object rituelData);

    String updateRituel(String id, Object rituelData);

    String deleteRituel(String id);

}
