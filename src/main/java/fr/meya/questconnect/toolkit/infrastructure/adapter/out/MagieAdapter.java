package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IMagieAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class MagieAdapter  implements IMagieAdapter {
    @Value("${toolkit.api.base.url}/magies")
    private String baseUrl;

    @Override
    public String getMagieList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/list";

        log.info("Adapter getMagieList - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getMagieList - Réponse reçue : {}", response);

        return response;
    }

    @Override
    public String updateMagie(Long id, Object magieData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/update/" + id;
        log.info("Adapter updateMagie - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, magieData);

        HttpEntity<Object> requestEntity = new HttpEntity<>(magieData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter updateMagie - Réponse reçue : {}", response);

        return response;
    }

    @Override
    public String createMagie(Object magieData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/create";
        log.info("Adapter createMagie - Envoi de la requête POST vers {} - Données : {}", url, magieData);

        HttpEntity<Object> requestEntity = new HttpEntity<>(magieData);
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        log.info("Adapter createMagie - Réponse reçue : {}", response);

        return response;
    }

    @Override
    public String deleteMagie(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/delete/" + id;
        log.info("Adapter deleteMagie - Envoi de la requête DELETE vers {} - ID : {}", url, id);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        log.info("Adapter deleteMagie - Réponse reçue : {}", response.getBody());

        return response.getBody();
    }
}
