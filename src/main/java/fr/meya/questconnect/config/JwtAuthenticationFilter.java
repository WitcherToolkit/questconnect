package fr.meya.questconnect.config;

import fr.meya.questconnect.toolkit.service.CustomUserDetailsService;
import io.jsonwebtoken.JwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // 1. LOGGER en premier (attribut de classe statique)
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    // 2. Puis vos attributs d'instance
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    // 3. Constructor
    public JwtAuthenticationFilter(JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String token = extractTokenFromRequest(request);

            if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                authenticateUser(request, token);
            }
        } catch (Exception e) {
            // Log l'erreur mais ne pas interrompre la chaîne de filtres
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    private void authenticateUser(HttpServletRequest request, String token) {
        try {
            // Valider le token en premier
            if (!jwtUtil.validateToken(token)) {
                System.out.println("JWT FILTER - Token non valide !");
                return;
            }

            // Extraire l'email seulement si le token est valide
            String email = jwtUtil.getEmailFromToken(token);
            System.out.println("JWT FILTER - Email extrait du token: " + email);

            if (email != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                // Créer l'authentification
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Définir l'authentification dans le contexte de sécurité
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (JwtException e) {
            System.out.println("JWT FILTER - Erreur JWT: " + e.getMessage());
            logger.warn("Invalid JWT token: {}", e.getMessage());
        } catch (Exception e) {
            System.out.println("JWT FILTER - Erreur auth: " + e.getMessage());
            logger.error("Error during authentication: {}", e.getMessage());
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        // Exclure les endpoints publics (login, register, etc.)
        return path.startsWith("/questconnect/api/auth/login") ||
                path.startsWith("/questconnect/api/auth/register") ||
                path.startsWith("/questconnect/actuator/");
    }
}