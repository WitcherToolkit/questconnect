package fr.meya.questconnect.toolkit.port.out;

public interface IRaceAdapter {

    String getRaceList();

    String updateRace(Long id, Object raceData);

    String createRace(Object raceData);

    String getRaceById(Long id);

}
