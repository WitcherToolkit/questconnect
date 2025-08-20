package fr.meya.questconnect.toolkit.port.out;

public interface ICaracteristiqueAdapter {

    String getCaracteristiqueList();

    String createCaracteristique(Object caracteristiqueData);

    String updateCaracteristique(Long id, Object caracteristiqueData);

}
