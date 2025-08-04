package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.ICaracteristiqueAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CaracteristiqueAdapter implements ICaracteristiqueAdapter {

    @Value("${toolkit.api.base.url}/caracteristiques")
    private String baseUrl;

    @Override
    public String getCaracteristiqueList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/list";

        log.info("Adapter - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getList - Réponse reçue : {}", response);

        return response;
    }

    @Override
    public String updateCaracteristique(Long id, Object caracteristiqueData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/update/" + id;
        log.info("Adapter - Envoi de la requête PUT vers {} - ID : {} - Données : {}", url, id, caracteristiqueData);

        HttpEntity<Object> requestEntity = new HttpEntity<>(caracteristiqueData);
        String response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
        log.info("Adapter  update - Réponse reçue : {}", response);

        return response;
    }

}
