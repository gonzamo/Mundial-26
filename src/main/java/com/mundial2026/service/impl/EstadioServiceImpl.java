package com.mundial2026.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundial2026.exception.ResourceNotFoundException;
import com.mundial2026.model.entity.Estadio;
import com.mundial2026.repository.EstadioRepository;
import com.mundial2026.service.EstadioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadioServiceImpl implements EstadioService{

    //Gracias a la anotación del constructor de lombok no hace falta poner @Autowired
    private final EstadioRepository estadioRepository;

    @Override
    public List<Estadio> obtenerTodos() {
        return estadioRepository.findAll();
    }

    @Override
    public Estadio obtenerPorId(Long id) {
        return estadioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estadio no encontrado con id: " + id));
    }

    @Override
    public Estadio guardar(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    @Override
    public void eliminar(Long id) {
        estadioRepository.deleteById(id);
    }
    
}
