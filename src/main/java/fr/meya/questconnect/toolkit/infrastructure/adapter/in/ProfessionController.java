package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.toolkit.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professions")
public class ProfessionController {
    @Autowired
    private ProfessionService professionService;

    @GetMapping
    public String getProfessionList(){
        return professionService.getProfessionList();
    }

    @GetMapping("/{id}/competences")
    public String getProfessionCompetences(@PathVariable Long id){
        return professionService.getProfessionCompetences(id);
    }

}
