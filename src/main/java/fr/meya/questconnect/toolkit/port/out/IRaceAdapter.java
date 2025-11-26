package fr.meya.questconnect.toolkit.port.out;

public interface IRaceAdapter {

    String getRaceList();

    String getRaceById(String id);

    String createRace(Object raceData);

    String updateRace(String id, Object raceData);

    String deleteRace(String id);
}
