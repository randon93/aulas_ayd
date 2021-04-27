package com.ayd.aulas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "aula")
@AllArgsConstructor
public class AulaEntity {

    @Id
    private Long id;
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY)
    private List<GrupoEntity> grupoEntities;

}
