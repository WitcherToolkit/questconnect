package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IMagieAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class MagieAdapter implements IMagieAdapter {

    private final RestClient restClient;

    // --- Récupérer la liste des magies ---
    @Override
    public String getMagieList(String niveau) {

        log.info("Adapter getMagieList - Envoi de la requête GET");

        String response = restClient.get()
                .uri("/magies/list")
                .retrieve()
                .body(String.class);

        log.info("Adapter getMagieList - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle magie ---
    @Override
    public String createMagie(Object magieData) {

        log.info("Adapter createMagie - Données : {}", magieData);

        String response = restClient.post()
                .uri("/magies/create")
                .body(magieData)
                .retrieve()
                .body(String.class);

        log.info("Adapter createMagie - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une magie existante ---
    @Override
    public String updateMagie(String id, Object magieData) {

        log.info("Adapter updateMagie - ID : {} - Données : {}", id, magieData);

        String response = restClient.put()
                .uri("/magies/update/{id}", id)
                .body(magieData)
                .retrieve()
                .body(String.class);

        log.info("Adapter updateMagie - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une magie ---
    @Override
    public String deleteMagie(String id) {

        log.info("Adapter deleteMagie - ID : {}", id);

        String response = restClient.delete()
                .uri("/magies/delete/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter deleteMagie - Réponse reçue : {}", response);
        return response;
    }
}
