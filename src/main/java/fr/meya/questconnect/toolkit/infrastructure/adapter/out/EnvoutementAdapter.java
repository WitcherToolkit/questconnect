package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IEnvoutementAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnvoutementAdapter implements IEnvoutementAdapter {

    private final RestClient restClient;

    // --- Récupérer la liste des envoûtements ---
    @Override
    public String getEnvoutementList() {

        log.info("Adapter getEnvoutementList - Envoi de la requête GET");

        String response = restClient.get()
                .uri("/envoutements/list")
                .retrieve()
                .body(String.class);

        log.info("Adapter getEnvoutementList - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer un nouvel envoûtement ---
    @Override
    public String createEnvoutement(Object envoutementData) {

        log.info("Adapter createEnvoutement - Données : {}", envoutementData);

        String response = restClient.post()
                .uri("/envoutements/create")
                .body(envoutementData)
                .retrieve()
                .body(String.class);

        log.info("Adapter createEnvoutement - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour un envoûtement existant ---
    @Override
    public String updateEnvoutement(String id, Object envoutementData) {

        log.info("Adapter updateEnvoutement - ID : {} - Données : {}", id, envoutementData);

        String response = restClient.put()
                .uri("/envoutements/update/{id}", id)
                .body(envoutementData)
                .retrieve()
                .body(String.class);

        log.info("Adapter updateEnvoutement - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer un envoûtement ---
    @Override
    public String deleteEnvoutement(String id) {

        log.info("Adapter deleteEnvoutement - ID : {}", id);

        String response = restClient.delete()
                .uri("/envoutements/delete/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter deleteEnvoutement - Réponse reçue : {}", response);
        return response;
    }
}