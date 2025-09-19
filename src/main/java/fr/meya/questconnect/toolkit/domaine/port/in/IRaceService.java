package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IRaceService {

    String getRaceList();

    String getRaceById(long id);

    String createRace(Object raceData);

    String updateRace(long id, Object raceData);

    String deleteRace(long id);

}
