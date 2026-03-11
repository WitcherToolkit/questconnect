package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.ICompetenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class CompetenceAdapter implements ICompetenceAdapter {

    private final RestClient restClient;

    // --- Récupérer la liste des compétences ---
    @Override
    public String getCompetenceList() {

        log.info("Adapter getCompetenceList - Envoi de la requête GET");

        String response = restClient.get()
                .uri("/competences/list")
                .retrieve()
                .body(String.class);

        log.info("Adapter getCompetenceList - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle compétence ---
    @Override
    public String createCompetence(Object competenceData) {

        log.info("Adapter createCompetence - Données : {}", competenceData);

        String response = restClient.post()
                .uri("/competences/create")
                .body(competenceData)
                .retrieve()
                .body(String.class);

        log.info("Adapter createCompetence - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une compétence ---
    @Override
    public String updateCompetence(String id, Object competenceData) {

        log.info("Adapter updateCompetence - ID : {} - Données : {}", id, competenceData);

        String response = restClient.put()
                .uri("/competences/update/{id}", id)
                .body(competenceData)
                .retrieve()
                .body(String.class);

        log.info("Adapter updateCompetence - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une compétence ---
    @Override
    public String deleteCompetence(String id) {

        log.info("Adapter deleteCompetence - ID : {}", id);

        String response = restClient.delete()
                .uri("/competences/delete/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter deleteCompetence - Réponse reçue : {}", response);
        return response;
    }
}