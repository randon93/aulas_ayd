package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteMapper;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class DocenteServiceCrearImpl implements DocenteServiceCrear {

    @Autowired
    private DocenteDao docenteDao;

    @Override
    public Long ejecutar(DocenteDto docenteDto) {
        existe(docenteDto.getNombre());
        DocenteEntity aulaEntity = DocenteMapper.INSTANCIA.aulaDtoToAulaEntity(docenteDto);
        return docenteDao.save(aulaEntity).getId();
    }

    private void existe(String nombre) {
        DocenteEntity docenteEntity = docenteDao.findByNombre(nombre).orElse(new DocenteEntity());
        if (Objects.nonNull(docenteEntity)) {
            throw new ExcepcionSinDatos("El docente ya existe en el sistema.");
        }
    }
}
