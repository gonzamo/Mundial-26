package com.mundial2026.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String escudoURL;

    private String entrenador;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;
}
