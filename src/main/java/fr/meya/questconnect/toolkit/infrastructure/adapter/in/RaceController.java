package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.domaine.port.in.IRaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/races")
public class RaceController {
    @Autowired
    private IRaceService raceService;

    // --- Récupérer la liste des races ---
    @GetMapping
    public String getRaceList() {
        log.info("consultation des races");
        String response = raceService.getRaceList();
        log.info("Liste des races récupérée avec succès");
        return response;
    }

    // --- Récupérer une race via l'id ---
    @GetMapping("/{id}")
    public String getRaceById(@PathVariable String id) {
        log.info("Consultation de la race avec l'ID : {}", id);
        String response = raceService.getRaceById(id);
        log.info("Race récupérée avec succès : {}", response);
        return response;

    }

    // --- Créer une nouvelle race ---
    @PostMapping("/create")
    public String createRace(@RequestBody Object raceData) {
        log.info("Création d'une nouvelle race - Données : {}", raceData);
        String response = raceService.createRace(raceData);
        log.info("Race créée avec succès");
        return response;
    }

    // --- Mettre à jour une race ---
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateRace(@PathVariable String id, @RequestBody Object raceData) {
        log.info("Modification de la race - ID : {} - Données : {}", id, raceData);
        String response = raceService.updateRace(id, raceData);
        log.info("Race modifiée avec succès");
        return response;
    }

    // --- Supprimer une race ---
    @DeleteMapping("/delete/{id}")
    public String deleteRace(@PathVariable String id) {
        log.info("Suppression de la race - ID : {}", id);
        String response = raceService.deleteRace(id);
        log.info("Race supprimée avec succès");
        return response;
    }
}
