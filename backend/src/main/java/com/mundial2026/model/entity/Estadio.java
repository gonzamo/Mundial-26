package com.mundial2026.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok genera getters, setters, toString...
@Data

//Crea un constructor vacío, sin parámetros
@NoArgsConstructor

// Crea un constructor con todos los campos
@AllArgsConstructor

//Le dice a Hibernate que esta clase es una tabla
@Entity

//Nombre de la tabla en BBDD
@Table(name = "estadio")
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String pais;

    private int capacidad;
}