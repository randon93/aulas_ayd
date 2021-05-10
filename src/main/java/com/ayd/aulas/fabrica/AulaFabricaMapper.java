package com.ayd.aulas.fabrica;

import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.entity.AulaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AulaFabricaMapper {

    AulaFabricaMapper INSTANCIA = Mappers.getMapper(AulaFabricaMapper.class);


    AulaDto aulaEnityToAulaDto(AulaEntity aulaEntity);

    AulaEntity aulaDtoToAulaEntity(AulaDto aulaDto);
}
