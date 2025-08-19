package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.MagieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api/magies")
public class MagieController {

    @Autowired
    private MagieService magieService;

    @GetMapping
    public String getMagieList(){
        log.info("Récupération de la liste des magies");
        String response = magieService.getMagieList();
        log.info("Liste des magies récupérée avec succès");
        return response;
    }

    // Attention, ne pas oublier de rajouter @PathVariable pour récupérer celui de l'url
    // Attention, ne pas oublier de rajouter @RequestBody
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateMagie(@PathVariable long id, @RequestBody Object magieData) {
        log.info("Modification de la magie - ID : {} - Données : {}", id, magieData);
        return magieService.updateMagie(id, magieData);
    }

    @PostMapping("/create")
    public String createMagie(@RequestBody Object magieData) {
        log.info("Création d'une nouvelle magie - Données : {}", magieData);
        return magieService.createMagie(magieData);
    }
}
