package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.GrupoEntity;

import java.util.ArrayList;

public class GrupoEntityToGrupoResponseDto {

    public static GrupoResponseDto entityToDto(GrupoEntity entity) {
        GrupoResponseDto dto = new GrupoResponseDto();
        dto.setAula(entity.getAula().getId());
        dto.setDocente(entity.getDocente().getId());
        dto.setEstrategias(new ArrayList<>());
        dto.setEstudiantes(new ArrayList<>());
        entity.getEstrategias().forEach(
                estrategia -> dto.getEstrategias().add(estrategia.getId())
        );
        entity.getEstudiantes().forEach(
                estudiante -> dto.getEstudiantes().add(estudiante.getId())
        );
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }
}
