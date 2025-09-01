package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Value("${toolkit.api.base.url}")
    private String witcherApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public User findByEmail(String email) {
        String url = witcherApiUrl + "/users/by-email?email=" + email;
        return restTemplate.getForObject(url, User.class);
    }
}
