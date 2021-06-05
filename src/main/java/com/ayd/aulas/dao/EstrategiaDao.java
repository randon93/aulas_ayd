package com.ayd.aulas.dao;

import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.entity.EstrategiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstrategiaDao extends JpaRepository<EstrategiaEntity, Long> {

    Optional<EstrategiaEntity> findByNombre(String nombre);
}
