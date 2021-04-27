package com.ayd.aulas.dao;

import com.ayd.aulas.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteDao extends JpaRepository<EstudianteEntity, Long> {
}
