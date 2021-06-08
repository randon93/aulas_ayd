package com.ayd.aulas.dto;

import lombok.Data;

import java.util.List;

@Data
public class GrupoDto {


    private Long id;
    private String nombre;
    private AulaDto aulaDto;
    private DocenteDto docenteDto;
    private List<EstudianteDto> estudianteDtos;
}
