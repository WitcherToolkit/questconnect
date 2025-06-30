package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.ICaracteristiqueAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CaracteristiqueAdapter implements ICaracteristiqueAdapter {
    @Value("${toolkit.api.base.url}")
    private String baseUrl;

    @Override
    public String getCaracteristiqueList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/caracteristiques/list";
        return restTemplate.getForObject(url, String.class);
    }
}
