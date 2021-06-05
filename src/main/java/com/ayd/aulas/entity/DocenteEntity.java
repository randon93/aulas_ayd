package com.ayd.aulas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "docente")
public class DocenteEntity extends UsuarioEntity{

    @Id
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<GrupoEntity> grupoEntities;
}
