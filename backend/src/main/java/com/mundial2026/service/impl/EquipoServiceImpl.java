package com.mundial2026.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundial2026.exception.ResourceNotFoundException;
import com.mundial2026.model.entity.Equipo;
import com.mundial2026.repository.EquipoRepository;
import com.mundial2026.service.EquipoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService{

    //Gracias a la anotación del constructor de lombok no hace falta poner @Autowired
    private final EquipoRepository equipoRepository;

    @Override
    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo obtenerPorId(Long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado con id: " + id));
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }
    
}
