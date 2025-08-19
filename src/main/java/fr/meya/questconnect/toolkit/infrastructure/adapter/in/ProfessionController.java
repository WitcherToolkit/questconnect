package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.ProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
