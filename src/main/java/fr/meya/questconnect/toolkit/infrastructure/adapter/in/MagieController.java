package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.domaine.port.in.IMagieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/magies")
public class MagieController {

    @Autowired
    private IMagieService magieService;

    // --- Récupérer la liste des magies ---
    @GetMapping
    public String getMagieList(@RequestParam(required = false) String niveau) {
        log.info("Récupération de la liste des magies" + (niveau != null ? " de niveau " + niveau : ""));
        String response = magieService.getMagieList(niveau);
        log.info("Liste des magies récupérée avec succès");
        return response;
    }

    // --- Créer une nouvelle magie ---
    @PostMapping("/create")
    public String createMagie(@RequestBody Object magieData) {
        log.info("Création d'une nouvelle magie - Données : {}", magieData);
        String response = magieService.createMagie(magieData);
        log.info("Magie créée avec succès");
        return response;
    }

    // --- Mettre à jour une magie existante ---
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateMagie(@PathVariable String id, @RequestBody Object magieData) {
        log.info("Modification de la magie - ID : {} - Données : {}", id, magieData);
        String response = magieService.updateMagie(id, magieData);
        log.info("Magie modifiée avec succès");
        return response;
    }

    // --- Supprimer une magie ---
    @DeleteMapping("/delete/{id}")
    public String deleteMagie(@PathVariable String id) {
        log.info("Suppression de la magie - ID : {}", id);
        String response = magieService.deleteMagie(id);
        log.info("Magie supprimée avec succès");
        return response;
    }

}
