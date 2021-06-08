package com.ayd.aulas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "grupo")
public class GrupoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    private AulaEntity aulaEntity;

    @ManyToOne
    private DocenteEntity docenteEntity;

    @OneToMany(fetch = FetchType.LAZY)
    private List<EstudianteEntity> estudianteEntities;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<EstrategiaEntity> estrategias;

}
