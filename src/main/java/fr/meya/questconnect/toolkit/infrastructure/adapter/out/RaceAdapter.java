package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IRaceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RaceAdapter implements IRaceAdapter {
    @Value("${toolkit.api.base.url}/races")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // --- Récupérer la liste des races ---
    @Override
    public String getRaceList() {
        String url = baseUrl + "/list";
        log.info("Adapter - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getRaceList - Réponse reçue : {}", response);
        return response;
    }

    // --- Récupérer une race ---
    @Override
    public String getRaceById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/" + id;
        log.info("Adapter - Envoi de la requête GET vers {} - ID : {}", url, id);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getRaceById - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle race ---
    @Override
    public String createRace(Object raceData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/create";
        log.info("Adapter createRace - Envoi de la requête POST vers {} - Données : {}", url, raceData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(raceData);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("Adapter createRace - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une race ---
    @Override
    public String updateRace(Long id, Object raceData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/update/" + id;
        log.info("Adapter - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, raceData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(raceData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter updateRace - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une race ---
    @Override
    public String deleteRace(Long id) {
        String url = baseUrl + "/delete/" + id;
        log.info("Adapter deleteRace - Envoi de la requête DELETE vers {} - ID : {}", url, id);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        log.info("Adapter deleteRace - Réponse reçue : {}", response.getBody());
        return response.getBody();
    }
}
