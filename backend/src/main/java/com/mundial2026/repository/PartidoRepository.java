package com.mundial2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mundial2026.model.entity.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long>{
    
}
