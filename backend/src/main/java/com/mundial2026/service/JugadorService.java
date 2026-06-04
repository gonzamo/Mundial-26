package com.mundial2026.service;

import java.util.List;

import com.mundial2026.model.entity.Jugador;

public interface JugadorService {
    
    List<Jugador> obtenerTodos();
    Jugador obtenerPorId(Long id);
    Jugador guardar(Jugador jugador);
    void eliminar(Long id);
}
