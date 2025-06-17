package fr.meya.questconnect.toolkit.service;

import fr.meya.questconnect.toolkit.port.out.ToolkitApiPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolkitService {

    @Autowired
    private ToolkitApiPortOut toolkitApiPortOut; //Port out pour l'appel à l'API Toolkit

    public String fetchRituelsFromToolkit() {
        return toolkitApiPortOut.fetchRituels();
    }
}
