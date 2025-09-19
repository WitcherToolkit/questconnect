package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.domaine.port.in.IProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/professions")
public class ProfessionController {
    @Autowired
    private IProfessionService professionService;

    // --- Récupérer la liste des professions ---
    @GetMapping
    public String getProfessionList(){
        log.info("Récupération de la liste des professions");
        String response = professionService.getProfessionList();
        log.info("Liste des professions récupérée avec succès");
        return response;
    }

    // --- Récupérer une profession avec ses compétences ---
    @GetMapping("/{id}/competences")
    public String getProfessionCompetences(@PathVariable Long id){
        log.info("Récupération de la liste compétences d'une profession");
        String response =  professionService.getProfessionCompetences(id);
        log.info("Liste compétences d'une profession récupérée avec succès");
        return response;
    }

    // --- Créer une nouvelle profession ---
    @PostMapping("/create")
    public String createProfession(@RequestBody Object professionData) {
        log.info("Création d'une nouvelle profession - Données : {}", professionData);
        String response = professionService.createProfession(professionData);
        log.info("Adapter createProfession - Réponse reçue : {}", response);
        return response;
    }

    // --- Mettre à jour une profession ---
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateProfession(@PathVariable long id, @RequestBody Object professionData) {
        log.info("Modification de la profession - ID : {} - Données : {}", id, professionData);
        String response = professionService.updateProfession(id, professionData);
        log.info("Adapter updateProfession - Réponse reçue : {}", response);
        return response;
    }

    // --- Supprimer une profession ---
    @DeleteMapping("/delete/{id}")
    public String deleteProfession(@PathVariable long id) {
        log.info("Suppression de la profession - ID : {}", id);
        String response = professionService.deleteProfession(id);
        log.info("Profession supprimée avec succès");
        return response;
    }
}
