package fr.meya.questconnect.toolkit.port.out;

public interface IRaceAdapter {

    String getRaceList();

    String getRaceById(Long id);

    String createRace(Object raceData);

    String updateRace(Long id, Object raceData);

    String deleteRace(Long id);
}
