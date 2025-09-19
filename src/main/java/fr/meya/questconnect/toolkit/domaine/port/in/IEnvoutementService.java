package fr.meya.questconnect.toolkit.domaine.port.in;

public interface IEnvoutementService {

    String getEnvoutementList();

    String createEnvoutement(Object envoutementData);

    String updateEnvoutement(long id, Object envoutementData);

    String deleteEnvoutement(long id);

}
