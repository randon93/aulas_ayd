package com.ayd.aulas.fabrica;

import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.entity.AulaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AulaMapper {

    AulaMapper INSTANCIA = Mappers.getMapper(AulaMapper.class);


    AulaDto aulaEnityToAulaDto(AulaEntity aulaEntity);

    AulaEntity aulaDtoToAulaEntity(AulaDto aulaDto);
}
