package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.port.in.IPersonnageService;
import fr.meya.questconnect.toolkit.port.out.IPersonnageAdapter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

/**
 * L'adaptateur permettant de communiquer avec l'API externe (WTB).
 * Injecté automatiquement par Spring grâce à @RequiredArgsConstructor.
 */
@Slf4j
@Service
public class PersonnageService implements IPersonnageService {
    private final IPersonnageAdapter personnageAdapter;

    public PersonnageService(IPersonnageAdapter personnageAdapter) {
        this.personnageAdapter = personnageAdapter;
    }

    /**
     * Récupère un personnage par son identifiant.
     * @param id L'identifiant du personnage.
     * @return Les données du personnage sous forme de chaîne JSON (ou DTO).
     */
     @Override
    public String getPersonnageById(String id) {
        log.debug("Service - Demande de récupération du personnage ID : {}", id);
        return personnageAdapter.getPersonnageById(id);
    }

    /**
     * Demande la création d'un nouveau personnage.
     * @param personnageData Les données du personnage à créer.
     * @return La réponse de l'API (généralement le personnage créé).
     */
    @Override
    public String createPersonnage(Object personnageData) {
        log.debug("Service - Demande de création de personnage");
        
        return personnageAdapter.createPersonnage(personnageData);
    }
}
