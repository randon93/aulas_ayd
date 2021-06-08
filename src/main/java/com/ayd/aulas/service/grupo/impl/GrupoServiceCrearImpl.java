package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.convertidores.GrupoMapper;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.service.grupo.GrupoServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GrupoServiceCrearImpl implements GrupoServiceCrear {

    @Autowired
    private GrupoDao grupoDao;

    @Override
    public Long ejecutar(GrupoDto grupoDto) {
        existo(grupoDto.getNombre());
        GrupoEntity grupoEntity = GrupoMapper.INSTANCIA.grupoDtoToGrupoEntity(grupoDto);
        return grupoDao.save(grupoEntity).getId();
    }

    private void existo(String nombre) {
        GrupoEntity grupoEntity = grupoDao.findByNombre(nombre).orElse(null);
        if (Objects.nonNull(grupoEntity)) {
            throw  new ExcepcionDuplicidad("El grupo ´" + nombre + "' ya existe");
        }
    }
}
