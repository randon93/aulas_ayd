package com.ayd.aulas.entity;

import lombok.Data;
import lombok.ToString;

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
    @ToString.Exclude
    private AulaEntity aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private DocenteEntity docente;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<EstudianteEntity> estudiantes;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "grupo_estrategia",
            joinColumns = { @JoinColumn(name = "grupo_id")},
            inverseJoinColumns = { @JoinColumn (name = "estrategia_id")})
    private List<EstrategiaEntity> estrategias;

    @Override
    public String toString() {
        return "GrupoEntity{}";
    }
}
