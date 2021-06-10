package com.ayd.aulas.dto;

import com.ayd.aulas.entity.EstrategiaEntity;
import lombok.Data;

import java.util.List;

@Data
public class GrupoDto {


    private Long id;
    private String nombre;
    private AulaDto aula;
    private DocenteDto docente;
    private List<EstudianteDto> estudiantes;
    private List<EstrategiaDto> estrategias;
}
