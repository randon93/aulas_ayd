package com.ayd.aulas.dao;

import com.ayd.aulas.entity.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AulaDao extends JpaRepository<AulaEntity, Long> {

    Optional<AulaEntity> findByNombre(String nombre);
}
