package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.entity.EstudianteEntity;
import org.springframework.stereotype.Component;

@Component
public class EstudianteEntityToEstudianteResponseDto {

    public EstudianteResponseDto entityToResponseDto(EstudianteEntity estudianteEntity) {

        EstudianteResponseDto responseDto = new EstudianteResponseDto();
        responseDto.setApellido(estudianteEntity.getApellido());
        responseDto.setContrasena(estudianteEntity.getContrasena());
        responseDto.setCorreo(estudianteEntity.getCorreo());
        responseDto.setId(estudianteEntity.getId());
        responseDto.setNombre(estudianteEntity.getNombre());
        responseDto.setRepitente(estudianteEntity.isRepitente());
        responseDto.setGrupos(estudianteEntity.getGrupos().getId());

        return responseDto;
    }
}
