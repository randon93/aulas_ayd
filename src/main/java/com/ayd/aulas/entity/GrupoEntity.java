package com.ayd.aulas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "grupo")
public class GrupoEntity {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private AulaEntity aulaEntity;

    @ManyToOne
    private DocenteEntity docenteEntity;

    @OneToMany
    private List<EstudianteEntity> estudianteEntities;

}
