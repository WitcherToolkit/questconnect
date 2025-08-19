package fr.meya.questconnect.toolkit.port.out;

public interface ICaracteristiqueAdapter {

    String getCaracteristiqueList();

    String updateCaracteristique(Long id, Object caracteristiqueData);

    String createCaracteristique(Object caracteristiqueData);

}
