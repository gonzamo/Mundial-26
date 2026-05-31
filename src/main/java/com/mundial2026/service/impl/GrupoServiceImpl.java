package com.mundial2026.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundial2026.model.entity.Grupo;
import com.mundial2026.repository.GrupoRepository;
import com.mundial2026.service.GrupoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrupoServiceImpl implements GrupoService{

    private final GrupoRepository grupoRepository;

    @Override
    public List<Grupo> obtenerTodos() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo obtenerPorId(Long id) {
        return grupoRepository.findById(id).orElseThrow();
    }

    @Override
    public Grupo guardar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public void eliminarPorId(Long id) {
        grupoRepository.deleteById(id);
    }
    
}
