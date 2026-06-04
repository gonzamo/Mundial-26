package com.mundial2026.service;

import java.util.List;

import com.mundial2026.model.entity.Estadio;

public interface EstadioService {
    
    List<Estadio> obtenerTodos();
    Estadio obtenerPorId(Long id);
    Estadio guardar(Estadio estadio);
    void eliminar(Long id);
}
