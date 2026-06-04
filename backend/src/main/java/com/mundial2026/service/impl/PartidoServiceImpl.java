package com.mundial2026.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundial2026.exception.ResourceNotFoundException;
import com.mundial2026.model.entity.Partido;
import com.mundial2026.repository.PartidoRepository;
import com.mundial2026.service.PartidoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoServiceImpl implements PartidoService{

    //Gracias a la anotación del constructor de lombok no hace falta poner @Autowired
    private final PartidoRepository partidoRepository;

    @Override
    public List<Partido> obtenerTodos() {
        return partidoRepository.findAll();
    }

    @Override
    public Partido obtenerPorId(Long id) {
        return partidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partido no encontrado con id: " + id));
    }

    @Override
    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }

    @Override
    public void eliminar(Long id) {
        partidoRepository.deleteById(id);
    }
    
}
