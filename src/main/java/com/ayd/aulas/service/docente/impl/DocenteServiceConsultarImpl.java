package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.convertidores.DocenteMapper;
import com.ayd.aulas.service.docente.DocenteServiceConsultar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceConsultarImpl implements DocenteServiceConsultar {

    @Autowired
    private DocenteDao docenteDao;

    public DocenteDto ejecutar(String nombre) {
        DocenteEntity docenteEntity = docenteDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionSinDatos("El docente" + nombre + "no existe")
        );
        return DocenteMapper.INSTANCIA.aulaEnityToAulaDto(docenteEntity);
    }
}
