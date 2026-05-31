package com.mundial2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mundial2026.model.entity.Estadio;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Long> {

    
}
