package fr.meya.questconnect.toolkit.port.out;

public interface IEnvoutementAdapter {

    String getEnvoutementList();

    String createEnvoutement(Object envoutementData);

    String updateEnvoutement(String id, Object envoutementData);

    String deleteEnvoutement(String id);

}
