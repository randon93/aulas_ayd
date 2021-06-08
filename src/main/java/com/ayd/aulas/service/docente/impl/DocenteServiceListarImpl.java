package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteMapper;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.service.docente.DocenteServiceListar;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DocenteServiceListarImpl implements DocenteServiceListar {

    @Autowired
    private DocenteDao docenteDao;

    @Override
    public List<DocenteDto> ejecutar(){
        List<DocenteDto> list = new ArrayList<>();
        for (DocenteEntity docenteEntity : docenteDao.findAll()) {
            list.add(
                    DocenteMapper.INSTANCIA.aulaEnityToAulaDto(docenteEntity)
            );
        }
        return list;
    }
}
