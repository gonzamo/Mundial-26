package com.mundial2026.service;

import java.util.List;

import com.mundial2026.model.entity.Equipo;

public interface EquipoService {

    List<Equipo> obtenerTodos();
    Equipo obtenerPorId(Long id);
    Equipo guardar(Equipo equipo);
    void eliminar(Long id);
}
