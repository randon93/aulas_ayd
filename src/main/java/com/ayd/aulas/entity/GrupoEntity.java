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

    @ManyToOne()
    private AulaEntity aulaId;

    @ManyToOne
    private DocenteEntity docente;

    @OneToMany(fetch = FetchType.LAZY)
    private List<EstudianteEntity> estudiantes;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<EstrategiaEntity> estrategias;

}
