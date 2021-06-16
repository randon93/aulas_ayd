package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.convertidores.AulaEntityToAulaResponseDto;
import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dto.AulaResponseDto;
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

    @Autowired
    private AulaEntityToAulaResponseDto toAulaResponseDto;

    @Override
    public List<AulaResponseDto> ejecutar() {
        List<AulaResponseDto> aulaDtos = new ArrayList<>();
        for (AulaEntity aulaEntity : aulaDao.findAll()) {
            aulaDtos.add(
                    toAulaResponseDto.entityToResponseDto(aulaEntity)
            );
        }
        return aulaDtos;
    }
}
