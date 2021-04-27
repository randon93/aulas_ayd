package com.ayd.aulas.fabrica;

import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.entity.AulaEntity;
import org.springframework.stereotype.Component;

@Component
public class AulaFabrica {

    public AulaEntity crearAulaEntity(AulaDto aulaDto){

        return new AulaEntity(aulaDto.getId(), aulaDto.getNombre(), aulaDto.getGrupoDtoList());
    }
}
