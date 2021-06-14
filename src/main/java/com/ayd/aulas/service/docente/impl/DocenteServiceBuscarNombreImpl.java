package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteMapper;
import com.ayd.aulas.convertidores.EstudianteMapper;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceBuscarNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceBuscarNombreImpl implements DocenteServiceBuscarNombre {

    @Autowired
    private DocenteDao docenteDao;

    @Override
    public DocenteDto ejecutar(String nombre) {
        DocenteEntity docenteEntity = docenteDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro al estudiante '" + nombre + "'.")
        );
        return DocenteMapper.INSTANCIA.aulaEnityToAulaDto(docenteEntity);
    }
}
