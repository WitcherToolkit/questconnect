package fr.meya.questconnect.toolkit.domaine.model;

import lombok.Data;
import java.util.Set;

@Data
public class User {
    private String id;
    private String email;
    private String password;
    private Set<String> roles;
}