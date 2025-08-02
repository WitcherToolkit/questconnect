package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.RituelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/rituels")
public class RituelController {

    @Autowired
    private RituelService rituelService;

    @GetMapping
    public String getRituelList(){
        log.info("Récupération de la liste des rituels");
        String response = rituelService.getRituelList();
        log.info("Liste des rituels récupérée avec succès");

        return response;
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateRituel(@PathVariable long id, @RequestBody Object rituelData) {
        log.info("Modification du rituel - ID : {} - Données : {}", id, rituelData);
        return rituelService.updateRituel(id, rituelData);
    }

}
