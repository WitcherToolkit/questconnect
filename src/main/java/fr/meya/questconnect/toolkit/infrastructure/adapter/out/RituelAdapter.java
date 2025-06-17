package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IRituelAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RituelAdapter implements IRituelAdapter {
    @Value("${toolkit.api.base.url}")
    private String baseUrl;

    @Override
    public String getRituelList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/rituels/list";
        return restTemplate.getForObject(url, String.class);
    }
}
