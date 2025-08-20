package fr.meya.questconnect.toolkit.port.out;

public interface IRituelAdapter {

    String getRituelList();

    String createRituel(Object rituelData);

    String updateRituel(Long id, Object rituelData);

    String deleteRituel(Long id);

}
