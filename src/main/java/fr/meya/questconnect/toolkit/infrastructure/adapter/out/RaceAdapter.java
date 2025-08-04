package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IRaceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RaceAdapter implements IRaceAdapter {
    @Value("${toolkit.api.base.url}/races")
    private String baseUrl;

    @Override
    public String getRaceList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/list";

        log.info("Adapter - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getRaceList - Réponse reçue : {}", response);

        return response;
    }

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
}
