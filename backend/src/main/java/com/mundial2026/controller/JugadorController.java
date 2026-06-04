package com.mundial2026.controller;

import com.mundial2026.model.entity.Jugador;
import com.mundial2026.service.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
public class JugadorController {

    private final JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<Jugador>> obtenerTodos() {
        return ResponseEntity.ok(jugadorService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Jugador> guardar(@RequestBody Jugador jugador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jugadorService.guardar(jugador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        jugadorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
