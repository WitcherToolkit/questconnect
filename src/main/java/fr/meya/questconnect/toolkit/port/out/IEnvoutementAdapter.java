package fr.meya.questconnect.toolkit.port.out;

public interface IEnvoutementAdapter {

    String getEnvoutementList();

    String updateEnvoutement(Long id, Object envoutementData);

    String createEnvoutement(Object envoutementData);
}
