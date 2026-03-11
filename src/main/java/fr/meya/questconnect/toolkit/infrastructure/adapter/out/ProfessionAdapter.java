package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.IProfessionAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProfessionAdapter implements IProfessionAdapter {

    private final RestClient restClient;

    // --- Récupérer la liste des professions ---
    @Override
    public String getProfessionList() {

        log.info("Adapter getProfessionList - Envoi de la requête GET");

        String response = restClient.get()
                .uri("/professions/list")
                .retrieve()
                .body(String.class);

        log.info("Adapter getProfessionList - Réponse reçue : {}", response);
        return response;
    }

    // --- Récupérer une profession avec des compétences ---
    @Override
    public String getProfessionCompetences(String id) {

        log.info("Adapter getProfessionCompetences - ID : {}", id);

        String response = restClient.get()
                .uri("/professions/detail/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter getProfessionCompetences - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle profession ---
    @Override
    public String createProfession(Object professionData) {

        log.info("Adapter createProfession - Données : {}", professionData);

        String response = restClient.post()
                .uri("/professions/create")
                .body(professionData)
                .retrieve()
                .body(String.class);

        log.info("Adapter createProfession - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une profession ---
    @Override
    public String updateProfession(String id, Object professionData) {

        log.info("Adapter updateProfession - ID : {} - Données : {}", id, professionData);

        String response = restClient.put()
                .uri("/professions/update/{id}", id)
                .body(professionData)
                .retrieve()
                .body(String.class);

        log.info("Adapter updateProfession - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une profession ---
    @Override
    public String deleteProfession(String id) {

        log.info("Adapter deleteProfession - ID : {}", id);

        String response = restClient.delete()
                .uri("/professions/delete/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter deleteProfession - Réponse reçue : {}", response);
        return response;
    }
}