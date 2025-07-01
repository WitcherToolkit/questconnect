package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IRaceAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RaceAdapter implements IRaceAdapter {
    @Value("${toolkit.api.base.url}")
    private String baseUrl;

    @Override
    public String getRaceList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/races/list";
        return restTemplate.getForObject(url, String.class);
    }
}
