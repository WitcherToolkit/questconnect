package fr.meya.questconnect.toolkit.infrastructure.adapter.out;

import fr.meya.questconnect.toolkit.port.out.ICaracteristiqueAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class CaracteristiqueAdapter implements ICaracteristiqueAdapter {

    private final RestClient restClient;

    // --- Récupérer la liste des caractéristiques ---
    @Override
    public String getCaracteristiqueList() {

        log.info("Adapter - Envoi de la requête GET getCaracteristiqueList");

        String response = restClient.get()
                .uri("/caracteristiques/list")
                .retrieve()
                .body(String.class);

        log.info("Adapter getList - Réponse reçue : {}", response);
        return response;
    }

    // --- Créer une nouvelle caractéristique ---
    @Override
    public String createCaracteristique(Object caracteristiqueData) {

        log.info("Adapter createCaracteristique - Données : {}", caracteristiqueData);

        String response = restClient.post()
                .uri("/caracteristiques/create")
                .body(caracteristiqueData)
                .retrieve()
                .body(String.class);

        log.info("Adapter createCaracteristique - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une caractéristique ---
    @Override
    public String updateCaracteristique(String id, Object caracteristiqueData) {

        log.info("Adapter updateCaracteristique - ID : {} - Données : {}", id, caracteristiqueData);

        String response = restClient.put()
                .uri("/caracteristiques/update/{id}", id)
                .body(caracteristiqueData)
                .retrieve()
                .body(String.class);

        log.info("Adapter updateCaracteristique - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une caractéristique ---
    @Override
    public String deleteCaracteristique(String id) {

        log.info("Adapter deleteCaracteristique - ID : {}", id);

        String response = restClient.delete()
                .uri("/caracteristiques/delete/{id}", id)
                .retrieve()
                .body(String.class);

        log.info("Adapter deleteCaracteristique - Réponse reçue : {}", response);
        return response;
    }
}