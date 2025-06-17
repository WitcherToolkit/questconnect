package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.ToolkitApiPortOut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ToolkitApiAdapter implements ToolkitApiPortOut {
    @Value("${toolkit.api.base.url}")
    private String toolkitApiBaseUrl;

    @Override
    public String fetchRituels() {
        RestTemplate restTemplate = new RestTemplate();
        String url = toolkitApiBaseUrl + "/rituels/list";
        return restTemplate.getForObject(url, String.class);
    }
}
