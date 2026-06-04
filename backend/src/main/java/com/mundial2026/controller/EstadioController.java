package com.mundial2026.controller;

import com.mundial2026.model.entity.Estadio;
import com.mundial2026.service.EstadioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadios")
@RequiredArgsConstructor
public class EstadioController {

    private final EstadioService estadioService;

    //ResponseEntity es el objeto que envuelve la respuesta HTTP
    @GetMapping
    public ResponseEntity<List<Estadio>> obtenerTodos() {
        return ResponseEntity.ok(estadioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadio> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadioService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Estadio> guardar(@RequestBody Estadio estadio) {   //@RequestBodyCoge el JSON del cuerpo de la petición
        return ResponseEntity.status(HttpStatus.CREATED).body(estadioService.guardar(estadio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}