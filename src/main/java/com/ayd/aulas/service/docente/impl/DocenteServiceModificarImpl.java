package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteMapper;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceModificarImpl implements DocenteServiceModificar {

    @Autowired
    private DocenteDao docenteDao;

    @Override
    public void ejecutar(DocenteDto docenteDto) {
        DocenteEntity docenteEntity = DocenteMapper.INSTANCIA.aulaDtoToAulaEntity(docenteDto);
        docenteDao.save(docenteEntity);
    }

    private void existe(Long id) {
        docenteDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("no existe el docente")
        );
    }
    
}
