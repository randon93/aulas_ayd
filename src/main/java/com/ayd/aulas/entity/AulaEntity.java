package com.ayd.aulas.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "aula")
public class AulaEntity {

    @Id
    private Long id;
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY)
    private List<GrupoEntity> grupoEntities;

}
