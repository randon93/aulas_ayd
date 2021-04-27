package com.ayd.aulas.dao;

import com.ayd.aulas.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoDao extends JpaRepository<GrupoEntity, Long> {
}
