package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.MagieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/magies")
public class MagieController {
    @Autowired
    private MagieService magieService;

    @RequestMapping
    public String getMagieList(){
        return magieService.getMagieList();
    }
}
