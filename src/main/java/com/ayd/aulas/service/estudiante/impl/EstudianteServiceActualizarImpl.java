package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.convertidores.EstudianteMapper;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.estudiante.EstudianteServiceActualizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EstudianteServiceActualizarImpl implements EstudianteServiceActualizar {

    @Autowired
    private EstudianteDao estudianteDao;

    @Autowired
    private GrupoDao grupoDao;

    @Override
    public void ejecutar(EstudianteDto estudianteDto) {
        existe(estudianteDto.getId());
        existeGrupo(estudianteDto.getGrupos());
        EstudianteEntity entity = EstudianteMapper.INSTANCIA.estudianteDtoToEstudianteEntity(estudianteDto);
        estudianteDao.save(entity);
    }

    private void existe(Long id){
        EstudianteEntity estudianteEntity = estudianteDao.findById(id).orElse(null);
        if (Objects.isNull(estudianteEntity)) {
            throw new ExcepcionDuplicidad("El estudiante no existe");
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
