package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IEnvoutementService {

    String getEnvoutementList();

    String createEnvoutement(Object envoutementData);

    String updateEnvoutement(String id, Object envoutementData);

    String deleteEnvoutement(String id);

}
