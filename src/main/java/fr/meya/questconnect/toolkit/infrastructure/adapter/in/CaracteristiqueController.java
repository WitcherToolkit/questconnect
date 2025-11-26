package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.domaine.port.in.ICaracteristiqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/caracteristiques")
public class CaracteristiqueController {

    @Autowired
    private ICaracteristiqueService caracteristiqueService;

    // --- Récupérer la liste des caractéristiques ---
    @GetMapping
    public String getCaracteristiqueList() {
        log.info("Récupération de la liste des caractéristiques");
        String response = caracteristiqueService.getCaracteristiqueList();
        log.info("Liste des caractéristiques récupérée avec succès");
        return response;
    }

    // --- Créer une nouvelle caractéristique ---
    @PostMapping("/create")
    public String createCaracteristique(@RequestBody Object caracteristiqueData) {
        log.info("Création d'une nouvelle caractéristique - Données : {}", caracteristiqueData);
        String response = caracteristiqueService.createCaracteristique(caracteristiqueData);
        log.info("Réponse création : {}", response);
        return response;
    }

    // --- Mettre à jour une caractéristique ---
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateCaracteristique(@PathVariable String id, @RequestBody Object caracteristiqueData) {
        log.info("Modification de la caractéristique - ID : {} - Données : {}", id, caracteristiqueData);
        String response = caracteristiqueService.updateCaracteristique(id, caracteristiqueData);
        log.info("Réponse mise à jour : {}", response);
        return response;
    }

    // --- Supprimer une caractéristique ---
    @DeleteMapping("/delete/{id}")
    public String deleteCaracteristique(@PathVariable String id) {
        log.info("Suppression de la caractéristique - ID : {}", id);
        String response = caracteristiqueService.deleteCaracteristique(id);
        log.info("Caractéristique supprimée avec succès");
        return response;
    }
}
