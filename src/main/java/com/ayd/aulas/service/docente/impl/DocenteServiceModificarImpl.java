package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;

public class DocenteServiceModificarImpl implements DocenteServiceModificar {

    @Autowired
    private DocenteDao docenteDao;

    @Override
    public void ejecutar(DocenteDto docenteDto) {
        existe(docenteDto.getId());
        docenteDao.deleteById(docenteDto.getId());
    }

    private void existe(Long id) {
        docenteDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("no existe el docente")
        );
    }
}
