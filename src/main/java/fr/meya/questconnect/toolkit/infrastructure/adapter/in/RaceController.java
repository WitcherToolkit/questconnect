package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/races")
public class RaceController {
    @Autowired
    private RaceService raceService;

    @GetMapping
    public String getRaceList() {

        log.info("consultation des races");
        String response = raceService.getRaceList();
        log.info("Liste des races récupérée avec succès");

        return response;
    }

    @GetMapping("/{id}")
    public String getRaceById(@PathVariable long id) {

        log.info("Consultation de la race avec l'ID : {}", id);
        String response = raceService.getRaceById(id);
        log.info("Race récupérée avec succès : {}", response);

        return response;

    }

    @PostMapping("/create")
    public String createRace(@RequestBody Object raceData) {

        log.info("Création d'une nouvelle race - Données : {}", raceData);
        String response = raceService.createRace(raceData);
        log.info("Race créée avec succès");

        return response;
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateRace(@PathVariable long id, @RequestBody Object raceData) {

        log.info("Modification de la race - ID : {} - Données : {}", id, raceData);
        String response = raceService.updateRace(id, raceData);
        log.info("Race modifiée avec succès");

        return response;
    }
}
