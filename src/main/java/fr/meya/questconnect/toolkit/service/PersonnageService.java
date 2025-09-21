package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.port.in.IPersonnageService;
import fr.meya.questconnect.toolkit.port.out.IPersonnageAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnageService implements IPersonnageService {
    @Autowired
    private IPersonnageAdapter personnageAdapter;

    @Override
    public String getPersonnageById(Long id) {
        return personnageAdapter.getPersonnageById(id);
    }

    @Override
    public String createPersonnage(Object personnageData) {
        return personnageAdapter.createPersonnage(personnageData);
    }
}
