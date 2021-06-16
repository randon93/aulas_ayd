package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.AulaResponseDto;
import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AulaResponseDtoToAulaEntity {

    @Autowired
    private GrupoDao grupoDao;

    public AulaEntity dtoResponseToEntity(AulaResponseDto dto) {
        AulaEntity entity = new AulaEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        dto.getGrupos().forEach(
                idGrupo -> {
                    GrupoEntity entityG = this.grupoDao.findById(idGrupo).orElseThrow(
                            () -> new ExcepcionSinDatos("EL grupo '" + idGrupo + "' no existe.")
                    );
                    entity.getGrupos().add(entityG);
                }
        );
        return entity;
    }
}
