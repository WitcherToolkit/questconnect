package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.domaine.port.in.IPersonnageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/personnages")
public class PersonnageController {

    @Autowired
    private IPersonnageService personnageService;

    // --- Consulter un persoonage ---
    @GetMapping("/{id}")
    public String getPersonnageById(@PathVariable String id) {
        log.info("Consultation du personnage - ID : {}", id);
        String response = personnageService.getPersonnageById(id);
        log.info("Personnage récupéré avec succès");
        return response;
    }

    // --- Créer un nouveau personnage ---
    @PostMapping("/create")
    public String createPersonnage(@RequestBody Object personnageData, @AuthenticationPrincipal UserDetails user) {
        log.info("Création d'une nouvelle personnage - Données : {}", personnageData);
        String username = user.getUsername();
        String response = personnageService.createPersonnage(personnageData);
        log.info("Personnage créée avec succès");
        return response;
    }
}
