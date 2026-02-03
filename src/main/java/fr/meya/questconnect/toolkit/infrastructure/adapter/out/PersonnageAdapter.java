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

    private final RestClient wtbClient;

    @Override
    public String getPersonnageById(String id) {
        // et ajoute l'URI ci-dessous (/personnages/{id})
        log.info("Adapter - Récupération ID : {}", id);
        
        return wtbClient.get()
                .uri("/personnages/{id}", id) 
                .retrieve()
                .body(String.class);
    }

    @Override
    public String createPersonnage(Object personnageData) {
        // et ajoute l'URI ci-dessous (/personnages)
        log.info("Adapter - Création : {}", personnageData);

        return wtbClient.post()
                .uri("/personnages") 
                .body(personnageData)
                .retrieve()
                .body(String.class);
    }
}
