package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.fabrica.AulaFabricaMapper;
import com.ayd.aulas.service.aula.AulaServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class AulaServiceCrearImpl implements AulaServiceCrear {

    @Autowired
    private AulaDao aulaDao;

    @Override
    public Long ejecutar(AulaDto aulaDto) {
        existe(aulaDto.getNombre());
        AulaEntity aulaEntity = AulaFabricaMapper.INSTANCIA.aulaDtoToAulaEntity(aulaDto);
        return aulaDao.save(aulaEntity).getId();
    }

    private void existe(String nombre){
       AulaEntity aulaEntity =  aulaDao.findByNombre(nombre).orElse(new AulaEntity());
       if (Objects.nonNull(aulaEntity)) {
            throw new ExcepcionSinDatos("El aula ya esta creada.");
       }
    }
}
