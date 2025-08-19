package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.CompetenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    @GetMapping
    public String getCompetenceList(){
        log.info("Récupération de la liste des competences");
        String response = competenceService.getCompetenceList();
        log.info("Liste des competences récupérée avec succès");

        return response;
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateCompetence(@PathVariable long id, @RequestBody Object competenceData) {
        log.info("Modification de la competence - ID : {} - Données : {}", id, competenceData);
        return competenceService.updateCompetence(id, competenceData);
    }

}
