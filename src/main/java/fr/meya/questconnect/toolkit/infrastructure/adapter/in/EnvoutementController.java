package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.EnvoutementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/envoutements")
public class EnvoutementController {
    @Autowired
    private EnvoutementService envoutementService;

    @GetMapping
    public String getEnvoutementList(){
        return envoutementService.getEnvoutementList();
    }
}
