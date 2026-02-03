package fr.meya.questconnect.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utilitaire pour la gestion des JSON Web Tokens (JWT).
 * Sait lire le token, extraire les informations et valider son authenticité.
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpirationMs;

    /**
     * Génère la clé cryptographique à partir du secret.
     * Utilise StandardCharsets.UTF_8 pour éviter les soucis d'encodage selon l'OS.
     */
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String email, Set<String> roles) {
        return Jwts.builder()
                .subject(email) // Remplacant de setSubject
                .claim("roles", roles)
                .issuedAt(new Date()) // Remplacant de setIssuedAt
                .expiration(new Date(System.currentTimeMillis() + jwtExpirationMs)) // Remplacant de setExpiration
                .signWith(getSigningKey()) // Plus besoin de préciser l'algo, il le déduit de la clé
                .compact();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey()) // Remplacant de setSigningKey
                .build()
                .parseSignedClaims(token) // Remplacant de parseClaimsJws
                .getPayload() // Remplacant de getBody()
                .getSubject();
    }

    public Set<String> getRolesFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        Object roles = claims.get("roles");
        if (roles instanceof Collection<?>) {
            return ((Collection<?>) roles).stream()
                    .map(Object::toString)
                    .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("JWT DEBUG - Erreur de validation: " + e.getMessage());
            return false;
        }
    }
}
