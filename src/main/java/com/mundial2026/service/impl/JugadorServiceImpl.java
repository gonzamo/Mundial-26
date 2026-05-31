package com.mundial2026.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mundial2026.model.entity.Jugador;
import com.mundial2026.repository.JugadorRepository;
import com.mundial2026.service.JugadorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadorServiceImpl implements JugadorService{

    //Gracias a la anotación del constructor de lombok no hace falta poner @Autowired
    private final JugadorRepository jugadorRepository;

    @Override
    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    @Override
    public Jugador obtenerPorId(Long id) {
        return jugadorRepository.findById(id).orElseThrow();
    }

    @Override
    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }
    
}
