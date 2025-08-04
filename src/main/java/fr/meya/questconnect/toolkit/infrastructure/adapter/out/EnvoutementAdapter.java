package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IEnvoutementAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EnvoutementAdapter implements IEnvoutementAdapter {
    @Value("${toolkit.api.base.url}/envoutements")
    private String baseUrl;

    @Override
    public String getEnvoutementList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/list";

        log.info("Adapter getEnvoutementList - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getEnvoutementList - Réponse reçue : {}", response);

        return response;
    }

    @Override
    public String updateEnvoutement(Long id, Object envoutementData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/update/" + id;
        log.info("Adapter updateEnvoutement - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, envoutementData);

        HttpEntity<Object> requestEntity = new HttpEntity<>(envoutementData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter updateEnvoutement - Réponse reçue : {}", response);

        return response;
    }
}
