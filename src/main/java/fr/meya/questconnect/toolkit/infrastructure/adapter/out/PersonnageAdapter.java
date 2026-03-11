package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IPersonnageAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonnageAdapter implements IPersonnageAdapter {

    private final RestClient restClient;

    @Override
    public String getPersonnageById(String id) {

        log.info("Adapter getPersonnageById - ID : {}", id);

        String response = restClient.get()
                .uri("/personnages/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter getPersonnageById - Réponse reçue : {}", response);
        return response;
    }

    @Override
    public String createPersonnage(Object personnageData) {

        log.info("Adapter createPersonnage - Données : {}", personnageData);

        String response = restClient.post()
                .uri("/personnages")
                .body(personnageData)
                .retrieve()
                .body(String.class);

        log.info("Adapter createPersonnage - Réponse reçue : {}", response);
        return response;
    }
}
