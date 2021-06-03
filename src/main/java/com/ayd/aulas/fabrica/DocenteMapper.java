package com.ayd.aulas.fabrica;

import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.entity.DocenteEntity;
import org.mapstruct.factory.Mappers;

public interface DocenteMapper {

    DocenteMapper INSTANCIA = Mappers.getMapper(DocenteMapper.class);


    DocenteDto aulaEnityToAulaDto(DocenteEntity docenteEntity);

    DocenteEntity aulaDtoToAulaEntity(DocenteDto docenteDto);
}
