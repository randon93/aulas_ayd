package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.convertidores.AulaMapper;
import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.aula.AulaServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;

public class AulaServiceModificarImpl implements AulaServiceModificar {

    @Autowired
    private AulaDao aulaDao;

    @Override
    public void ejecutar(AulaDto aulaDto) {
        existe(aulaDto.getId());
        AulaEntity aulaEntity = AulaMapper.INSTANCIA.aulaDtoToAulaEntity(aulaDto);
        aulaDao.save(aulaEntity);
    }

    private void existe(Long id){
        aulaDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("El aula a actualizar no existe")
        );
    }
}
