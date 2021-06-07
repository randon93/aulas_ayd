package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.convertidores.EstudianteMapper;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.estudiante.EstudianteServiceBuscarNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceBuscarNombreImpl implements EstudianteServiceBuscarNombre {

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    public EstudianteDto ejecutar(String nombre) {
        EstudianteEntity estudianteEntity = estudianteDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro al estudiante '" + nombre + "'.")
        );
        return EstudianteMapper.INSTANCIA.estudianteEntityToEstudianteDto(estudianteEntity);
    }
}
