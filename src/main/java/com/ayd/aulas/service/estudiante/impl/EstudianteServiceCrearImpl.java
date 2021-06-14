package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.convertidores.EstudianteMapper;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.estudiante.EstudianteServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EstudianteServiceCrearImpl implements EstudianteServiceCrear {

    @Autowired
    private EstudianteDao estudianteDao;

    @Autowired
    private GrupoDao grupoDao;

    @Override
    public Long ejecutar(EstudianteDto estudianteDto) {
        existe(estudianteDto.getNombre());
        existeGrupo(estudianteDto.getGrupos());
        EstudianteEntity entity = EstudianteMapper.INSTANCIA.estudianteDtoToEstudianteEntity(estudianteDto);
        return estudianteDao.save(entity).getId();
    }

    private void existe(String nombre) {
        EstudianteEntity estudianteEntity = estudianteDao.findByNombre(nombre).orElse(null);
        if (Objects.nonNull(estudianteEntity)) {
            throw new ExcepcionDuplicidad("El estudiante ya existe");
        }
    }

    private void existeGrupo(GrupoDto dto) {
        if (Objects.nonNull(dto)) {
            grupoDao.findById(dto.getId()).orElseThrow(
                    () -> new ExcepcionSinDatos("El grupo '" + dto.getNombre() + " - " + dto.getAula().getNombre() + "' al que asignan al estudiante no existe")
            );
        }
    }

}
