package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.estrategia.EstrategiaServicioEliminar;
import org.springframework.beans.factory.annotation.Autowired;

public class EstrategiaServiceEliminarImpl implements EstrategiaServicioEliminar {

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Override
    public void ejecutar(Long id) {

    }

    private void exite(Long id) {
        estrategiaDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("Estrategia con el id '" + id + "' no existe")
        );
    }
}
