package com.ayd.aulas.dao;

import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteDao extends JpaRepository<DocenteEntity, Long> {
}
