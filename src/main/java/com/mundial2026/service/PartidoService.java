package com.mundial2026.service;

import java.util.List;

import com.mundial2026.model.entity.Partido;

public interface PartidoService {
    
    List<Partido> obtenerTodos();
    Partido obtenerPorId(Long id);
    Partido guardar(Partido partido);
    void eliminar(Long id);
}
