package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.convertidores.EstrategiaMapper;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.service.estrategia.EstrategiaServiceListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstrategiaServiceListarImpl implements EstrategiaServiceListar {

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Override
    public List<EstrategiaDto> ejecutar() {
        List<EstrategiaDto> list = new ArrayList<>();
        for (EstrategiaEntity entity: estrategiaDao.findAll()) {
            list.add(
                    EstrategiaMapper.INSTANCIA.estrategiaEntityToEstrategiaDto(entity)
            );
        }
        return list;
    }
}
