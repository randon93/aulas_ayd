package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.convertidores.EstrategiaMapper;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.estrategia.EstrategiaServiceBuscarNombre;
import org.springframework.beans.factory.annotation.Autowired;

public class EstrategiaServiceBuscarNombreImpl implements EstrategiaServiceBuscarNombre {

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Override
    public EstrategiaDto ejecutar(String nombre) {
        EstrategiaDto estrategiaDto = EstrategiaMapper.INSTANCIA.estrategiaEntityToEstrategiaDto(
                estrategiaDao.findByNombre(nombre).orElseThrow(
                        () -> new ExcepcionSinDatos("No se encontro la estrategia '" + nombre + "' en el sistema.")
                )
        );
        return estrategiaDto;
    }
}
