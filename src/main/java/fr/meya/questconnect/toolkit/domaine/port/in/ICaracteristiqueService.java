package fr.meya.questconnect.toolkit.domaine.port.in;

public interface ICaracteristiqueService {

    String getCaracteristiqueList();

    String createCaracteristique(Object caracteristiqueData);

    String updateCaracteristique(String id, Object caracteristiqueData);

    String deleteCaracteristique(String id);

}
