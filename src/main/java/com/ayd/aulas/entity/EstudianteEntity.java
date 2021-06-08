package com.ayd.aulas.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "estudiante")
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean repitente;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    @ManyToOne
    private GrupoEntity grupoEntity;
}
