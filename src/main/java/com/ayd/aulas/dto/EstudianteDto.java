package com.ayd.aulas.dto;

import lombok.Data;

@Data
public class EstudianteDto {

    private Long id;
    private boolean repitente;
    private GrupoDto grupoDto;
}
