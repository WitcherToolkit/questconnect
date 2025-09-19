package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.domaine.port.in.IEnvoutementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/envoutements")
public class EnvoutementController {
    @Autowired
    private IEnvoutementService envoutementService;

    // --- Récupérer la liste des envoûtements ---
    @GetMapping
    public String getEnvoutementList() {
        log.info("Récupération de la liste des envoûtements");
        String response = envoutementService.getEnvoutementList();
        log.info("Liste des envoûtements récupérée avec succès");
        return response;
    }

    // --- Créer un nouvel envoûtement ---
    @PostMapping("/create")
    public String createEnvoutement(@RequestBody Object envoutementData) {
        log.info("Création d'un nouvel envoûtement - Données : {}", envoutementData);
        String response = envoutementService.createEnvoutement(envoutementData);
        log.info("Envoûtement créé avec succès");
        return response;
    }

    // --- Mettre à jour un envoûtement existant ---
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateEnvoutement(@PathVariable long id, @RequestBody Object envoutementData) {
        log.info("Modification de l'envoûtement - ID : {} - Données : {}", id, envoutementData);
        String response = envoutementService.updateEnvoutement(id, envoutementData);
        log.info("Envoûtement modifié avec succès");
        return response;
    }

    // --- Supprimer un envoûtement ---
    @DeleteMapping("/delete/{id}")
    public String deleteEnvoutement(@PathVariable long id) {
        log.info("Suppression de l'envoûtement - ID : {}", id);
        String response = envoutementService.deleteEnvoutement(id);
        log.info("Envoûtement supprimé avec succès");
        return response;
    }
}
