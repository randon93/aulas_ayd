package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.convertidores.EstrategiaMapper;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.estrategia.EstrategiaServiceBuscarNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EstrategiaServiceBuscarNombreImpl implements EstrategiaServiceBuscarNombre {

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Override
    public EstrategiaDto ejecutar(String nombre) {
        EstrategiaEntity entity = existo(nombre);
        EstrategiaDto estrategiaDto = EstrategiaMapper.INSTANCIA.estrategiaEntityToEstrategiaDto(entity);
        return estrategiaDto;
    }

    private EstrategiaEntity existo(String nombre) {
        EstrategiaEntity entity = estrategiaDao.findByNombre(nombre).orElse(null);
        if (Objects.isNull(entity)) {
            throw new ExcepcionSinDatos("No se encontro la estrategia '" + nombre + "' en el sistema.");
        }
        return entity;
    }
}
