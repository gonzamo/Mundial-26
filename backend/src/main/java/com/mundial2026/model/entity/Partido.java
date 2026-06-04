package com.mundial2026.model.entity;

import java.time.LocalDateTime;

import com.mundial2026.model.enums.EstadoPartido;
import com.mundial2026.model.enums.FasePartido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok genera getters, setters, toString...
@Data

// Crea un constructor vacío, sin parámetros
@NoArgsConstructor

// Crea un constructor con todos los campos
@AllArgsConstructor

// Le dice a Hibernate que esta clase es una tabla
@Entity

// Nombre de la tabla en BBDD
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    private Equipo equipoVisitante;

    @Column(nullable = false)
    private int golesLocal;

    @Column(nullable = false)
    private int golesVisitante;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    @Enumerated(EnumType.STRING)
    private FasePartido fase;

    @Enumerated(EnumType.STRING)
    private EstadoPartido estado;
}
