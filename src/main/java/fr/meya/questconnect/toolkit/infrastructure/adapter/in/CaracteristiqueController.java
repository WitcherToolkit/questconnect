package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.CaracteristiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/caracteristiques")
public class CaracteristiqueController {
    @Autowired
    private CaracteristiqueService caracteristiqueService;

    @GetMapping
    public String getCaracteristiqueList(){
        return caracteristiqueService.getCaracteristiqueList();
    }
}
