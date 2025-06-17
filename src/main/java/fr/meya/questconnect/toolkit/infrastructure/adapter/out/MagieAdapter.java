package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IMagieAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MagieAdapter  implements IMagieAdapter {
    @Value("${toolkit.api.base.url}")
    private String baseUrl;

    @Override
    public String getMagieList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/magies/list";
        return restTemplate.getForObject(url, String.class);
    }
}
