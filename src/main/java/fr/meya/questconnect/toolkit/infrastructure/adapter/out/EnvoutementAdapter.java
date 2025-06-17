package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IEnvoutementAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EnvoutementAdapter implements IEnvoutementAdapter {
    @Value("${toolkit.api.base.url}")
    private String baseUrl;

    @Override
    public String getEnvoutementList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/envoutements/list";
        return restTemplate.getForObject(url, String.class);
    }
}
