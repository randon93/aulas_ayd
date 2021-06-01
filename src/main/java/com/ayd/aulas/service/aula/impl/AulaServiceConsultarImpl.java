package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.fabrica.AulaFabricaMapper;
import com.ayd.aulas.service.aula.AulaServiceConsultar;
import org.springframework.beans.factory.annotation.Autowired;

public class AulaServiceConsultarImpl  implements AulaServiceConsultar {

    @Autowired
    private AulaDao aulaDao;

    public AulaDto ejecutar(String nombre) {
        AulaEntity aulaEntity = aulaDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionSinDatos("El aula" + nombre + "no existe")
        );
        return AulaFabricaMapper.INSTANCIA.aulaEnityToAulaDto(aulaEntity);
    }
}