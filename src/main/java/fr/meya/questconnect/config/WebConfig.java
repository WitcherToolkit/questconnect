package fr.meya.questconnect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applique la configuration CORS à tous les chemins de l'API
                // Indique l'origine (domaine + port) de votre application Angular
                // Assurez-vous que c'est le bon port (souvent 4200 pour Angular dev)
                .allowedOrigins("http://localhost:4200")
                // Méthodes HTTP autorisées
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // En-têtes autorisés dans la requête
                .allowedHeaders("*")
                // Autorise l'envoi de credentials (cookies, en-têtes d'autorisation)
                .allowCredentials(true)
                // Durée de validité du pré-vol CORS (en secondes)
                .maxAge(3600); // Optionnel, mais recommandé pour optimiser les requêtes
    }
}
