package com.ayd.aulas.dao;

import com.ayd.aulas.entity.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AulaDao extends JpaRepository<AulaEntity, Long> {

    Optional<AulaEntity> findByNombre(String nombre);
}
