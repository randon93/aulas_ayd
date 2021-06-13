package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.convertidores.AulaMapper;
import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.AulaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.aula.AulaServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceModificarImpl implements AulaServiceModificar {

    @Autowired
    private AulaDao aulaDao;

    @Autowired
    private GrupoDao grupoDao;

    @Override
    public void ejecutar(AulaDto aulaDto) {
        existe(aulaDto.getId());
        existeGrupos(aulaDto.getGrupos());
        AulaEntity aulaEntity = AulaMapper.INSTANCIA.aulaDtoToAulaEntity(aulaDto);
        aulaDao.save(aulaEntity);
    }

    private void existe(Long id){
        aulaDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("El aula a actualizar no existe")
        );
    }

    private void existeGrupos(List<GrupoDto> grupoDtos){
        for (int i = 0; i < grupoDtos.size(); i++) {
            GrupoDto dto = grupoDtos.get(i);
            grupoDao.findById(dto.getId()).orElseThrow(
                    () -> new ExcepcionSinDatos("El grupo '" + dto.getNombre() + "' no existe")
            );
        }
    }
}
