package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IProfessionAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ProfessionAdapter implements IProfessionAdapter {
    @Value("${toolkit.api.base.url}/profession")
    private String baseUrl;

    @Override
    public String getProfessionList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/list";

        log.info("Adapter - Envoi de la requête GET vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getList - Réponse reçue : {}", response);

        return response;
    }

    @Override
    public String getProfessionCompetences(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/detail/" + id;

        log.info("Adapter - Envoi de la requête GET getProfessionCompetence vers {}", url);
        String response = restTemplate.getForObject(url, String.class);
        log.info("Adapter getProfessionCompetence - Réponse reçue : {}", response);

        return response;
    }
}
