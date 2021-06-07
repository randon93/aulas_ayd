package com.ayd.aulas.dao;

import com.ayd.aulas.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoDao extends JpaRepository<GrupoEntity, Long> {
}
