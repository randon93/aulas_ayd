package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.convertidores.AulaMapper;
import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.service.aula.AulaServiceListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AulaServiceListarImpl implements AulaServiceListar {

    @Autowired
    private AulaDao aulaDao;

    @Override
    public List<AulaDto> ejecutar() {
        List<AulaDto> aulaDtos = new ArrayList<>();
        for (AulaEntity aulaEntity : aulaDao.findAll()) {
            aulaDtos.add(
                    AulaMapper.INSTANCIA.aulaEnityToAulaDto(aulaEntity)
            );
        }
        return aulaDtos;
    }
}
