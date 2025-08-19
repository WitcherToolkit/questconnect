package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.EnvoutementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/envoutements")
public class EnvoutementController {
    @Autowired
    private EnvoutementService envoutementService;

    @GetMapping
    public String getEnvoutementList(){
        log.info("Récupération de la liste des envoûtements");
        String response = envoutementService.getEnvoutementList();
        log.info("Liste des entoûtements récupérée avec succès");
        return response;
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateEnvoutement(@PathVariable long id, @RequestBody Object envoutementData) {
        log.info("Modification de l'envoutement - ID : {} - Données : {}", id, envoutementData);
        return envoutementService.updateEnvoutement(id, envoutementData);
    }

    @PostMapping("/create")
    public String createEnvoutement(@RequestBody Object envoutementData) {
        log.info("Création d'un nouvel envoutement - Données : {}", envoutementData);
        return envoutementService.createEnvoutement(envoutementData);
    }
}
