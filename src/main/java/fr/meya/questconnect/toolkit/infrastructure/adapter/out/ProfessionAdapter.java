package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IProfessionAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProfessionAdapter implements IProfessionAdapter {
    @Value("${toolkit.api.base.url}")
    private String baseUrl;

    @Override
    public String getProfessionList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/profession/list";
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public String getProfessionCompetences(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/profession/detail/" + id;
        return restTemplate.getForObject(url, String.class);
    }
}
