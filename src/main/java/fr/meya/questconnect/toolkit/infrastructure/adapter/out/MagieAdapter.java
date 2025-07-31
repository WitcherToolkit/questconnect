package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IMagieAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Slf4j
@Component
public class MagieAdapter  implements IMagieAdapter {
    @Value("${toolkit.api.base.url}/magies")
    private String baseUrl;

    @Override
    public String getMagieList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/list";
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public String updateMagie(Long id, Object magieData) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/update/" + id;
        HttpEntity<Object> requestEntity = new HttpEntity<>(magieData);
        return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
    }


}
