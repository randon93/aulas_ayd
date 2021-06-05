package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.convertidores.EstrategiaMapper;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.service.estrategia.EstrategiaServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;

public class EstrategiaServiceCrearImpl implements EstrategiaServiceCrear {

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Override
    public Long ejecutar(EstrategiaDto estrategiaDto) {
        existe(estrategiaDto.getNombre());
        EstrategiaEntity estrategiaEntity = EstrategiaMapper.INSTANCIA.estrategiaDtoToEstrategiaEntity(estrategiaDto);
        return estrategiaDao.save(estrategiaEntity).getId();
    }

    private void existe(String nombre) {
        EstrategiaEntity existo = estrategiaDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionDuplicidad("Estrategia '" + nombre + "' ya esxiste.")
        );
    }
}
