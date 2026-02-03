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
            // 1. GESTION DU CORS (Cross-Origin Resource Sharing)
            // On dit à Spring d'utiliser notre méthode 'corsConfigurationSource' définie plus bas.
            // Cela permet à ton Frontend Angular (sur le port 4200) de parler à ce Backend (sur un autre port).
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))

            // 2. DESACTIVATION CSRF
            // Le CSRF est une protection pour les sessions basées sur les cookies.
            // Comme on utilise des Tokens (JWT), on n'en a pas besoin, on le désactive pour faciliter les tests.
            .csrf(csrf -> csrf.disable())

            // 3. GESTION DE SESSION : STATELESS
            // Très important pour une API REST avec JWT.
            // On dit au serveur : "Ne garde aucune info en mémoire après la requête".
            // Chaque requête doit prouver son identité à nouveau (via le token).
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // 4. AUTORISATIONS DES URLS (Le plan du bâtiment)
            .authorizeHttpRequests(auth -> auth
                    // Les routes "/login" et "/register" sont publiques (tout le monde peut essayer de se connecter).
                    // ATTENTION : Si ton app a un préfixe (ex: /questconnect), ajoute-le ici !
                    .requestMatchers("/api/auth/login", "/api/auth/register").permitAll()
                    
                    // Toutes les autres requêtes nécessitent d'être connecté (avoir un token valide).
                    .anyRequest().authenticated()
            )

            // 5. INSERTION DE NOTRE FILTRE
            // On demande à Spring d'exécuter TON filtre (JwtAuthenticationFilter)
            // AVANT le filtre standard de gestion des mots de passe.
            // Si ton filtre valide le token, l'utilisateur est connecté avant même d'arriver au filtre standard.
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
        auth.userDetailsService(userDetailsService) // Utilise la logique pour trouver l'user
            .passwordEncoder(passwordEncoder);      // Utilise cet encodeur pour vérifier le mot de passe
    }
}