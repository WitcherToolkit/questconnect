package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.domaine.port.in.IRituelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/rituels")
public class RituelController {

    @Autowired
    private IRituelService rituelService;

    // --- Récupérer la liste des rituels ---
    @GetMapping
    public String getRituelList() {
        log.info("Récupération de la liste des rituels");
        String response = rituelService.getRituelList();
        log.info("Liste des rituels récupérée avec succès");
        return response;
    }

    // --- Créer un nouveau rituel ---
    @PostMapping("/create")
    public String createRituel(@RequestBody Object rituelData) {
        log.info("Création d'un nouveau rituel - Données : {}", rituelData);
        String response = rituelService.createRituel(rituelData);
        log.info("Rituel créé avec succès");
        return response;
    }

    // --- Mettre à jour un rituel existant ---
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateRituel(@PathVariable long id, @RequestBody Object rituelData) {
        log.info("Modification du rituel - ID : {} - Données : {}", id, rituelData);
        String response = rituelService.updateRituel(id, rituelData);
        log.info("Rituel modifié avec succès");
        return response;
    }

    // --- Supprimer un rituel ---
    @DeleteMapping("/delete/{id}")
    public String deleteRituel(@PathVariable long id) {
        log.info("Suppression de la rituel - ID : {}", id);
        String response = rituelService.deleteRituel(id);
        log.info("Rituel supprimée avec succès");
        return response;
    }

}
