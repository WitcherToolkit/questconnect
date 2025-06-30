package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.ICompetenceAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CompetenceAdapter implements ICompetenceAdapter {
    @Value("${toolkit.api.base.url}")
    private String baseUrl;

    @Override
    public String getCompetenceList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/competences/list";
        return restTemplate.getForObject(url, String.class);
    }
}
