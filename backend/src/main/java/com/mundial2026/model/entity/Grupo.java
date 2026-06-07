package com.mundial2026.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String letra;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
    private List<Equipo> equipos;
    
}
