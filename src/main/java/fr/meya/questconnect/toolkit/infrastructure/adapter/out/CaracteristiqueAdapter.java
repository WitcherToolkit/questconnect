package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.ICaracteristiqueAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CaracteristiqueAdapter implements ICaracteristiqueAdapter {

    @Value("${toolkit.api.base.url}/caracteristiques")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // --- Récupérer la liste des caractéristiques ---
    @Override
    public String getCaracteristiqueList() {
        String url = baseUrl + "/list";
        log.info("Adapter - Envoi de la requête GET getCaracteristiqueList vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getList - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle caractéristique ---
    @Override
    public String createCaracteristique(Object caracteristiqueData) {
        String url = baseUrl + "/create";
        log.info("Adapter createCaracteristique - Envoi de la requête POST vers {} - Données : {}", url, caracteristiqueData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(caracteristiqueData);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("Adapter createCaracteristique - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une caractéristique ---
    @Override
    public String updateCaracteristique(Long id, Object caracteristiqueData) {
        String url = baseUrl + "/update/" + id;
        log.info("Adapter updateCaracteristique - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, caracteristiqueData);
        HttpEntity<Object> requestEntity = new HttpEntity<>(caracteristiqueData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter updateCaracteristique - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une caractéristique ---
    @Override
    public String deleteCaracteristique(Long id) {
        String url = baseUrl + "/delete/" + id;
        log.info("Adapter deleteCaracteristique - Envoi de la requête DELETE vers {} - ID : {}", url, id);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        log.info("Adapter deleteCaracteristique - Réponse reçue : {}", response.getBody());
        return response.getBody();
    }
}
