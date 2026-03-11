package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IRaceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class RaceAdapter implements IRaceAdapter {

    private final RestClient restClient;

    // --- Récupérer la liste des races ---
    @Override
    public String getRaceList() {

        log.info("Adapter getRaceList - Envoi de la requête GET");

        String response = restClient.get()
                .uri("/races/list")
                .retrieve()
                .body(String.class);

        log.info("Adapter getRaceList - Réponse reçue : {}", response);
        return response;
    }

    // --- Récupérer une race ---
    @Override
    public String getRaceById(String id) {

        log.info("Adapter getRaceById - ID : {}", id);

        String response = restClient.get()
                .uri("/races/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter getRaceById - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle race ---
    @Override
    public String createRace(Object raceData) {

        log.info("Adapter createRace - Données : {}", raceData);

        String response = restClient.post()
                .uri("/races/create")
                .body(raceData)
                .retrieve()
                .body(String.class);

        log.info("Adapter createRace - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une race ---
    @Override
    public String updateRace(String id, Object raceData) {

        log.info("Adapter updateRace - ID : {} - Données : {}", id, raceData);

        String response = restClient.put()
                .uri("/races/update/{id}", id)
                .body(raceData)
                .retrieve()
                .body(String.class);

        log.info("Adapter updateRace - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une race ---
    @Override
    public String deleteRace(String id) {

        log.info("Adapter deleteRace - ID : {}", id);

        String response = restClient.delete()
                .uri("/races/delete/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter deleteRace - Réponse reçue : {}", response);
        return response;
    }
}