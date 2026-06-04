package com.mundial2026.controller;

import com.mundial2026.dto.LoginRequest;
import com.mundial2026.dto.AuthResponse;
import com.mundial2026.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        // 1. Verifica usuario y contraseña
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        // 2. Carga el usuario
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        // 3. Genera el token
        String token = jwtService.generarToken(userDetails.getUsername());

        // 4. Devuelve el token
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registro(@RequestBody com.mundial2026.model.entity.Usuario usuario) {
        return ResponseEntity.ok("Registro no implementado aún");
    }

    //TEMPORAL
    @GetMapping("/generar-password")
    public ResponseEntity<String> generarPassword() {
        return ResponseEntity.ok(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("1234"));
    }
}