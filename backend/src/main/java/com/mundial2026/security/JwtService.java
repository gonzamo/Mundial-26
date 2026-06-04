package com.mundial2026.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "mundial2026-clave-secreta-muy-larga-para-que-sea-segura";
    private static final long EXPIRACION = 86400000; // 24 horas en milisegundos

    // Convierte el texto de SECRET_KEY en una clave criptográfica que entiende la librería JWT.
    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Genera un token para un usuario
    public String generarToken(String username) {
        return Jwts.builder()
                .subject(username) // quien es el usuario
                .issuedAt(new Date()) // cuando se creó
                .expiration(new Date(System.currentTimeMillis() + EXPIRACION)) // cuando caduca
                .signWith(getKey()) // firma con la clave secreta
                .compact(); // genera el String final
    }

    // Extrae el username del token
    public String extraerUsername(String token) {
        return Jwts.parser()
                .verifyWith(getKey()) // verifica la firma
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject(); // extrae el username
    }

    // Valida si el token es correcto
    public boolean validarToken(String token, String username) {
        return extraerUsername(token).equals(username);
    }
}