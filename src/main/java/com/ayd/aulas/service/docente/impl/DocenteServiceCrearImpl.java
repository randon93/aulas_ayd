package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteMapper;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DocenteServiceCrearImpl implements DocenteServiceCrear {

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private GrupoDao grupoDao;

    @Override
    public Long ejecutar(DocenteDto docenteDto) {
        existe(docenteDto.getNombre());
        existeGrupo(docenteDto.getGrupos());
        DocenteEntity aulaEntity = DocenteMapper.INSTANCIA.aulaDtoToAulaEntity(docenteDto);
        return docenteDao.save(aulaEntity).getId();
    }

    private void existe(String nombre) {
        DocenteEntity docenteEntity = docenteDao.findByNombre(nombre).orElse(null);
        if (Objects.nonNull(docenteEntity)) {
            throw new ExcepcionDuplicidad("El docente ya existe");
        }
    }

    private void existeGrupo(List<GrupoDto> dtos) {
        if (Objects.nonNull(dtos)){
            for (int i = 0; i < dtos.size(); i++) {
                GrupoDto dto = dtos.get(i);
                grupoDao.findById(dto.getId()).orElseThrow(
                        () -> new ExcepcionSinDatos("El grupo '" + dto.getNombre() + "'No existe.")
                );
            }
        }
    }
}
