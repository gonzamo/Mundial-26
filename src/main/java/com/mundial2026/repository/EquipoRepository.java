package com.mundial2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mundial2026.model.entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long>{
    
}
