package com.mundial2026.controller;

import com.mundial2026.model.entity.Grupo;
import com.mundial2026.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoService grupoService;

    @GetMapping
    public ResponseEntity<List<Grupo>> obtenerTodos() {
        return ResponseEntity.ok(grupoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(grupoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Grupo> guardar(@RequestBody Grupo grupo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(grupoService.guardar(grupo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        grupoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
