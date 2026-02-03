package fr.meya.questconnect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Classe de configuration principale de la sécurité (Spring Security).
 * <p>
 * Son rôle est d'agir comme un "vigile" à l'entrée de l'application :
 * 1. Elle vérifie qui a le droit d'entrer (CORS).
 * 2. Elle vérifie l'identité (Authentification).
 * 3. Elle décide quelles portes sont ouvertes ou fermées (Autorisation).
 */
@Configuration
public class SecurityConfig {

    @Autowired
    private fr.meya.questconnect.toolkit.service.CustomUserDetailsService userDetailsService; // Ton service qui va chercher les utilisateurs en BDD

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter; // Ton filtre "Fait maison" qui vérifie le Token

    @Autowired
    private PasswordEncoder passwordEncoder; // L'outil pour vérifier les mots de passe hachés (BCrypt)

    /**
     * Définit la chaîne de filtres de sécurité.
     * C'est ici qu'on configure toutes les règles HTTP.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/login", "/api/auth/register").permitAll()
                    .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Définit les règles précises du CORS.
     * C'est ici qu'on ouvre les "douanes" pour Angular.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Autorise uniquement ton frontend Angular
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        
        // Autorise les verbes HTTP classiques
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Autorise tous les types d'entêtes (ex: Authorization, Content-Type...)
        configuration.setAllowedHeaders(List.of("*"));
        
        // Autorise l'envoi de cookies ou d'infos d'authentification (nécessaire parfois)
        configuration.setAllowCredentials(true);
        
        // Durée de mise en cache de la réponse "pre-flight" (la demande de permission CORS)
        configuration.setMaxAge(3600L); // 1 heure

        // Applique ces règles à toutes les routes de l'application ("/**")
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * Configuration globale de l'authentification.
     * C'est ici qu'on "branche" le service utilisateur et l'encodeur de mot de passe
     * au gestionnaire d'authentification de Spring.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }
}