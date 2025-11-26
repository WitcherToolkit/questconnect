package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.domaine.port.in.ICaracteristiqueService;
import fr.meya.questconnect.toolkit.port.out.ICaracteristiqueAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaracteristiqueService implements ICaracteristiqueService {

    @Autowired
    private ICaracteristiqueAdapter caracteristiqueAdapter;

    public String getCaracteristiqueList() {
        return caracteristiqueAdapter.getCaracteristiqueList();
    }

    public String createCaracteristique(Object caracteristiqueData) {
        return caracteristiqueAdapter.createCaracteristique(caracteristiqueData);
    }

    public String updateCaracteristique(String id, Object caracteristiqueData) {
        return caracteristiqueAdapter.updateCaracteristique(id, caracteristiqueData);
    }

    public String deleteCaracteristique(String id) {
        return caracteristiqueAdapter.deleteCaracteristique(id);
    }

}
