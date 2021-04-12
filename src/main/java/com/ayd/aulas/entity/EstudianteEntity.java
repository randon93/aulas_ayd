package com.ayd.aulas.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "estudiante")
public class EstudianteEntity extends UsuarioEntity {

    @Id
    private Long id;
    private boolean repitente;

    @ManyToOne
    private GrupoEntity grupoEntity;


}
