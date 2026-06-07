package com.mundial2026.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mundial2026.model.enums.PosicionJugador;

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
@Table(name = "jugador")
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private PosicionJugador posicion;
    
    @Column(nullable = false)
    private int dorsal;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private int goles;

    @Column(nullable = false)
    private int asistencias;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}
