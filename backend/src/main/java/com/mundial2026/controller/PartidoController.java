package com.mundial2026.controller;

import com.mundial2026.model.entity.Partido;
import com.mundial2026.service.PartidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@RequiredArgsConstructor
public class PartidoController {

    private final PartidoService partidoService;

    @GetMapping
    public ResponseEntity<List<Partido>> obtenerTodos() {
        return ResponseEntity.ok(partidoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(partidoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Partido> guardar(@RequestBody Partido partido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partidoService.guardar(partido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        partidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
