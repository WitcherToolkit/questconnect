package fr.meya.questconnect.toolkit.infrastructure.adapter.in;

import fr.meya.questconnect.config.JwtUtil;
import fr.meya.questconnect.toolkit.domaine.model.User;
import fr.meya.questconnect.toolkit.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(user.getEmail(), user.getRoles());
        return Map.of("token", token);
    }

    @Data
    public static class AuthRequest {
        private String email;
        private String password;
    }
}