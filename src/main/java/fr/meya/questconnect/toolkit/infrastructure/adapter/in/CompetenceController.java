package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.domaine.port.in.ICompetenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    @Autowired
    private ICompetenceService competenceService;

    // --- Récupérer la liste des compétences ---
    @GetMapping
    public String getCompetenceList(){
        log.info("Récupération de la liste des competences");
        String response = competenceService.getCompetenceList();
        log.info("Liste des competences récupérée avec succès");
        return response;
    }

    // --- Créer une nouvelle compétence ---
    @PostMapping("/create")
    public String createCompetence(@RequestBody Object competenceData) {
        log.info("Création d'une nouvelle competence - Données : {}", competenceData);
        String response = competenceService.createCompetence(competenceData);
        log.info("Réponse création : {}", response);
        return response;
    }

    // --- Mettre à jour une compétence ---
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateCompetence(@PathVariable long id, @RequestBody Object competenceData) {
        log.info("Modification de la competence - ID : {} - Données : {}", id, competenceData);
        String response = competenceService.updateCompetence(id, competenceData);
        log.info("Réponse mise à jour : {}", response);
        return response;
    }

    // --- Supprimer une compétence ---
    @DeleteMapping("/delete/{id}")
    public String deleteCompetence(@PathVariable long id) {
        log.info("Suppression de la caractéristique - ID : {}", id);
        String response = competenceService.deleteCompetence(id);
        log.info("Compétence supprimée avec succès");
        return response;
    }
}
