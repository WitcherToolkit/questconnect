package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.ICompetenceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CompetenceAdapter implements ICompetenceAdapter {

    @Value("${toolkit.api.base.url}/competences")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // --- Récupérer la liste des compétences ---
    @Override
    public String getCompetenceList() {
        String url = baseUrl + "/list";
        log.info("Adapter getCompetenceList - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getCompetenceList - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle compétence ---
    @Override
    public String createCompetence(Object competenceData) {
        String url = baseUrl + "/create";
        log.info("Adapter createCompetence - Envoi de la requête POST vers {} - Données : {}", url, competenceData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(competenceData);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("Adapter createCompetence - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une compétence ---
    @Override
    public String updateCompetence(Long id, Object competenceData) {
        String url = baseUrl + "/update/" + id;
        log.info("Adapter updateCompetence - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, competenceData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(competenceData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter updateCompetence - Réponse reçue : {}", response);
        return response;

    }

    // --- Supprimer une compétence ---
    @Override
    public String deleteCompetence(Long id) {
        String url = baseUrl + "/delete/" + id;
        log.info("Adapter deleteCompetence - Envoi de la requête DELETE vers {} - ID : {}", url, id);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        log.info("Adapter deleteCompetence - Réponse reçue : {}", response.getBody());
        return response.getBody();
    }
}
