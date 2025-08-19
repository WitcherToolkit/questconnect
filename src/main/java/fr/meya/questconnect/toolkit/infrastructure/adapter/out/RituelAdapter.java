package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IRituelAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RituelAdapter implements IRituelAdapter {
    @Value("${toolkit.api.base.url}/rituels")
    private String baseUrl;

    @Override
    public String getRituelList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/list";

        log.info("Adapter getRituelList - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getRituelList - Réponse reçue : {}", response);

        return response;
    }

    @Override
    public String updateRituel(Long id, Object rituelData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/update/" + id;
        log.info("Adapter updateRituel - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, rituelData);

        HttpEntity<Object> requestEntity = new HttpEntity<>(rituelData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter updateRituel - Réponse reçue : {}", response);

        return response;
    }

    @Override
    public String createRituel(Object rituelData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/create";
        log.info("Adapter createRituel - Envoi de la requête POST vers {} - Données : {}", url, rituelData);

        HttpEntity<Object> requestEntity = new HttpEntity<>(rituelData);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("Adapter createRituel - Réponse reçue : {}", response);

        return response;
    }

}
