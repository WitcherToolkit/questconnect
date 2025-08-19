package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.CaracteristiqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/caracteristiques")
public class CaracteristiqueController {

    @Autowired
    private CaracteristiqueService caracteristiqueService;

    @GetMapping
    public String getCaracteristiqueList(){
        log.info("Récupération de la liste des caractéristiques");
        String response = caracteristiqueService.getCaracteristiqueList();
        log.info("Liste des caractéristiques récupérée avec succès");

        return response;
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public String updateCaracteristique(@PathVariable long id, @RequestBody Object caracteristiqueData) {
        log.info("Modification de la caracteristique - ID : {} - Données : {}", id, caracteristiqueData);
        return caracteristiqueService.updateCaracteristique(id, caracteristiqueData);
    }

    @PostMapping("/create")
    public String createCaracteristique(@RequestBody Object caracteristiqueData) {
        log.info("Création d'une nouvelle caracteristique - Données : {}", caracteristiqueData);
        return caracteristiqueService.createCaracteristique(caracteristiqueData);
    }

}
