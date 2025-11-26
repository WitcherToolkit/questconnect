package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IRaceService {

    String getRaceList();

    String getRaceById(String id);

    String createRace(Object raceData);

    String updateRace(String id, Object raceData);

    String deleteRace(String id);

}
