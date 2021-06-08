package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.grupo.GrupoServiceActualizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GrupoServiceActualizarImpl implements GrupoServiceActualizar {

    @Autowired
    private GrupoDao grupoDao;

    @Override
    public void ejecutar(GrupoDto grupoDto) {
       GrupoEntity grupoEntity = existo(grupoDto.getId());
       grupoDao.save(grupoEntity);
    }

    private GrupoEntity existo(Long id) {
        GrupoEntity grupoEntity = grupoDao.findById(id).orElse(null);
        if (Objects.isNull(grupoEntity)) {
            throw new ExcepcionSinDatos("No existe el grupo que desea actualizar");
        }
        return grupoEntity;
    }
}
