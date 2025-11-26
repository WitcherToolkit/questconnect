package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IPersonnageAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class PersonnageAdapter implements IPersonnageAdapter {
    @Value("${toolkit.api.base.url}/personnages")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();


    // --- Récupérer un personnage ---
    @Override
    public String getPersonnageById(String id) {
        String url = baseUrl + "/" + id;
        log.info("Adapter getPersonnageById - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getPersonnageById - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle personnage ---
    @Override
    public String createPersonnage(Object personnageData) {
        String url = baseUrl + "/create";
        log.info("Adapter createPersonnage - Envoi de la requête POST vers {} - Données : {}", url, personnageData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(personnageData);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("Adapter createPersonnage - Réponse reçue : {}", response);
        return response;
    }
}
