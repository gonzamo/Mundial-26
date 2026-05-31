package com.mundial2026.service;

import java.util.List;

import com.mundial2026.model.entity.Grupo;

public interface GrupoService {
    
    List<Grupo> obtenerTodos();
    Grupo obtenerPorId(Long id);
    Grupo guardar(Grupo grupo);
    void eliminarPorId(Long id);
    
}
