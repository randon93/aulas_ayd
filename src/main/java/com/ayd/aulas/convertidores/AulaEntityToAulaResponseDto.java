package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.AulaResponseDto;
import com.ayd.aulas.entity.AulaEntity;

public class AulaEntityToAulaResponseDto {

    public static AulaResponseDto entityToResponseDto(AulaEntity entity) {
        AulaResponseDto dto = new AulaResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        entity.getGrupos().forEach(
                entityG -> dto.getGrupos().add(entityG.getId())
        );
        return dto;
    }
}
