package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.ProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/professions")
public class ProfessionController {
    @Autowired
    private ProfessionService professionService;

    @GetMapping
    public String getProfessionList(){
        log.info("Récupération de la liste des professions");
        String response = professionService.getProfessionList();
        log.info("Liste des professions récupérée avec succès");

        return response;
    }

    @GetMapping("/{id}/competences")
    public String getProfessionCompetences(@PathVariable Long id){
        log.info("Récupération de la liste compétences d'une profession");
        String response =  professionService.getProfessionCompetences(id);
        log.info("Liste compétences d'une profession récupérée avec succès");

        return response;
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateProfession(@PathVariable long id, @RequestBody Object professionData) {
        log.info("Modification de la profession - ID : {} - Données : {}", id, professionData);
        return professionService.updateProfession(id, professionData);
    }

}
