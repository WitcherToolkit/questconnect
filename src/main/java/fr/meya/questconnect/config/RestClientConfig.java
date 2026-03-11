package fr.meya.questconnect.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestClient;

/**
 * Configuration du client REST pour communiquer avec le service WTB.
 * S'assure que le token JWT reçu d'Angular est bien transmis à WTB.
 */
@Configuration
public class RestClientConfig {

    @Value("${toolkit.api.base.url}")
    private String wtbBaseUrl;

    private static final Logger logger = LoggerFactory.getLogger(RestClientConfig.class);

    @Bean
    public RestClient restClient(RestClient.Builder builder) {

        return builder
                .baseUrl(wtbBaseUrl) // URL de WitcherToolkit-Back
                .requestInterceptor((request, body, execution) -> {

                    // 1. Récupérer l'authentification actuelle
                    Authentication authentication = SecurityContextHolder
                            .getContext()
                            .getAuthentication();

                    // 2. Vérifier si c'est bien TON type d'authentification
                    if (authentication instanceof UsernamePasswordAuthenticationToken auth) {

                        // 3. Récupérer le token brut qu'on a stocké dans les "credentials"
                        Object credentials = auth.getCredentials();

                        if (credentials instanceof String token) {
                            logger.debug("Ajout du token JWT à la requête sortante vers WTB");
                            request.getHeaders().setBearerAuth(token);
                        } else {
                            logger.warn("Token JWT introuvable dans les credentials");
                        }
                    } else {
                        logger.warn("Aucune authentification trouvée ou type incompatible pour la requête sortante");
                    }

                    return execution.execute(request, body);
                })
                .build();
    }
}
