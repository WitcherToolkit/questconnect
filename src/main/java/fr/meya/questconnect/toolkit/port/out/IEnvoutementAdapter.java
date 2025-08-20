package fr.meya.questconnect.toolkit.port.out;

public interface IEnvoutementAdapter {

    String getEnvoutementList();

    String createEnvoutement(Object envoutementData);

    String updateEnvoutement(Long id, Object envoutementData);

    String deleteEnvoutement(Long id);

}
