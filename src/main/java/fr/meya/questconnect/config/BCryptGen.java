package fr.meya.questconnect.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptGen {
    public static void main(String[] args) {
        //admin@demo.com
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode("Pa$$W0rdTest");
        System.out.println(hash);

        System.out.println(encoder.matches("Pa$$W0rdTest", "$2a$10$lJuSc5EoaqzFJR9wqPigtu6/wW3fqWSX9T0G6ih8tV09MGPbuxwdK"));
    }
}
