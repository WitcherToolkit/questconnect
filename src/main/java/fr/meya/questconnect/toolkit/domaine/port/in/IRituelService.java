package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IRituelService {

    String getRituelList();

    String createRituel(Object rituelData);

    String updateRituel(String id, Object rituelData);

    String deleteRituel(String id);

}
