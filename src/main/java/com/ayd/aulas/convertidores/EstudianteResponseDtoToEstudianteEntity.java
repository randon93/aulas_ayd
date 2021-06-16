package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstudianteResponseDtoToEstudianteEntity {

    @Autowired
    private GrupoDao grupoDao;

    public EstudianteEntity responseToEntity(EstudianteResponseDto responseDto) {
        EstudianteEntity entity = new EstudianteEntity();
        entity.setApellido(responseDto.getApellido());
        entity.setContrasena(responseDto.getContrasena());
        entity.setCorreo(responseDto.getCorreo());
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());
        entity.setRepitente(responseDto.isRepitente());
        GrupoEntity grupoEntity = grupoDao.findById(responseDto.getGrupos()).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro el grupo '" + responseDto.getGrupos() + "'.")
        );
        entity.setGrupos(grupoEntity);
        return entity;
    }
}
