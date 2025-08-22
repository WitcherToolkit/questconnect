package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IProfessionAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ProfessionAdapter implements IProfessionAdapter {
    @Value("${toolkit.api.base.url}/professions")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // --- Récupérer la liste des professions ---
    @Override
    public String getProfessionList() {
        String url = baseUrl + "/list";
        log.info("Adapter - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getList - Réponse reçue : {}", response);
        return response;
    }

    // --- Récupérer une profession avec des compétences ---
    @Override
    public String getProfessionCompetences(Long id) {
        String url = baseUrl + "/detail/" + id;
        log.info("Adapter - Envoi de la requête GET getProfessionCompetence vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getProfessionCompetence - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle profession ---
    @Override
    public String createProfession(Object professionData) {
        String url = baseUrl + "/create";
        log.info("Adapter createProfession - Envoi de la requête POST vers {} - Données : {}", url, professionData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(professionData);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("Adapter createProfession - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une profession ---
    @Override
    public String updateProfession (Long id, Object professionData) {
        String url = baseUrl + "/update/" + id;
        log.info("Adapter - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, professionData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(professionData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter updateProfession - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une profession ---
    @Override
    public String deleteProfession(Long id) {
        String url = baseUrl + "/delete/" + id;
        log.info("Adapter deleteProfession - Envoi de la requête DELETE vers {} - ID : {}", url, id);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        log.info("Adapter deleteProfession - Réponse reçue : {}", response.getBody());
        return response.getBody();
    }
}