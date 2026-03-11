package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IRituelAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class RituelAdapter implements IRituelAdapter {

    private final RestClient restClient;

    // --- Récupérer la liste des rituels ---
    @Override
    public String getRituelList() {

        log.info("Adapter getRituelList - Envoi de la requête GET");

        String response = restClient.get()
                .uri("/rituels/list")
                .retrieve()
                .body(String.class);

        log.info("Adapter getRituelList - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer un nouveau rituel ---
    @Override
    public String createRituel(Object rituelData) {

        log.info("Adapter createRituel - Données : {}", rituelData);

        String response = restClient.post()
                .uri("/rituels/create")
                .body(rituelData)
                .retrieve()
                .body(String.class);

        log.info("Adapter createRituel - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour un rituel existant ---
    @Override
    public String updateRituel(String id, Object rituelData) {

        log.info("Adapter updateRituel - ID : {} - Données : {}", id, rituelData);

        String response = restClient.put()
                .uri("/rituels/update/{id}", id)
                .body(rituelData)
                .retrieve()
                .body(String.class);

        log.info("Adapter updateRituel - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer un rituel ---
    @Override
    public String deleteRituel(String id) {

        log.info("Adapter deleteRituel - ID : {}", id);

        String response = restClient.delete()
                .uri("/rituels/delete/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter deleteRituel - Réponse reçue : {}", response);
        return response;
    }
}
