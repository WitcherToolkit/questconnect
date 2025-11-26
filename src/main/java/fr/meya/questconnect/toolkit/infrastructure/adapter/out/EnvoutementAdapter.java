package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IEnvoutementAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EnvoutementAdapter implements IEnvoutementAdapter {
    @Value("${toolkit.api.base.url}/envoutements")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // --- Récupérer la liste des envoûtements ---
    @Override
    public String getEnvoutementList() {
        String url = baseUrl + "/list";
        log.info("Adapter getEnvoutementList - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getEnvoutementList - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer un nouvel envoûtement ---
    @Override
    public String createEnvoutement(Object envoutementData) {
        String url = baseUrl + "/create";
        log.info("Adapter createEnvoutement - Envoi de la requête POST vers {} - Données : {}", url, envoutementData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(envoutementData);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("Adapter createEnvoutement - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour un envoûtement existant ---
    @Override
    public String updateEnvoutement(String id, Object envoutementData) {
        String url = baseUrl + "/update/" + id;
        log.info("Adapter updateEnvoutement - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, envoutementData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(envoutementData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter updateEnvoutement - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer un envoûtement ---
    @Override
    public String deleteEnvoutement(String id) {
        String url = baseUrl + "/delete/" + id;
        log.info("Adapter deleteEnvoutement - Envoi de la requête DELETE vers {} - ID : {}", url, id);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        log.info("Adapter deleteEnvoutement - Réponse reçue : {}", response.getBody());
        return response.getBody();
    }
}
