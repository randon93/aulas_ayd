package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.convertidores.EstudianteMapper;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.service.estudiante.EstudianteServiceListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteServiceListarImpl implements EstudianteServiceListar {

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    public List<EstudianteDto> ejecutar() {
        List<EstudianteDto> list = new ArrayList<>();
        for (EstudianteEntity entity: estudianteDao.findAll()) {
            list.add(
                    EstudianteMapper.INSTANCIA.estudianteEntityToEstudianteDto(entity)
            );
        }
        return list;
    }
}
