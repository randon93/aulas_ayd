package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteMapper;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceModificarImpl implements DocenteServiceModificar {

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private GrupoDao grupoDao;

    @Override
    public void ejecutar(DocenteDto docenteDto) {
        existe(docenteDto.getId());
        existeGrupo(docenteDto.getGrupos());
        DocenteEntity docenteEntity = DocenteMapper.INSTANCIA.aulaDtoToAulaEntity(docenteDto);
        docenteDao.save(docenteEntity);
    }

    private void existe(Long id) {
        docenteDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("no existe el docente")
        );
    }

    private void existeGrupo(List<GrupoDto> dtos) {
        for (int i = 0; i < dtos.size(); i++) {
            GrupoDto dto = dtos.get(i);
            grupoDao.findById(dto.getId()).orElseThrow(
                    () -> new ExcepcionSinDatos("El grupo '" + dto.getNombre() + "'No existe.")
            );
        }
    }
    
}
