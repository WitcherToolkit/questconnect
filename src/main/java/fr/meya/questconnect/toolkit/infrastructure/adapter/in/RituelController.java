package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.RituelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rituels")
public class RituelController {
    @Autowired
    private RituelService rituelService;

    @GetMapping
    public String getRituels(){
        return rituelService.getRituelList();
    }
}
