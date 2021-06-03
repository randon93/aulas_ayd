package com.ayd.aulas.dao;

import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocenteDao extends JpaRepository<DocenteEntity, Long> {

    Optional<DocenteEntity> findByNombre(String nombre);
}
