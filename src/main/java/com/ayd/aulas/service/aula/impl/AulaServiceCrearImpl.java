package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.aula.AulaServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class AulaServiceCrearImpl implements AulaServiceCrear {

    @Autowired
    private AulaDao aulaDao;

    @Override
    public void crearAula(AulaEntity aulaEntity) {
        existe(aulaEntity.getNombre());
        aulaDao.save(aulaEntity);
    }

    private void existe(String nombre){
       AulaEntity aulaEntity =  aulaDao.findByNombre(nombre).orElse(new AulaEntity());
       if (Objects.nonNull(aulaEntity)) {
            throw new ExcepcionSinDatos("El aula ya esta creada.");
       }
    }
}
