package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoResponseDtoToGrupoEntity {

    @Autowired
    private AulaDao aulaDao;

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Autowired
    private EstudianteDao estudianteDao;

    public GrupoEntity responseToEntoty(GrupoResponseDto responseDto) {


        GrupoEntity entity = new GrupoEntity();

        entity.setAula(aulaDao.findById(responseDto.getAula()).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro el aula")
        ));
        entity.setDocente(docenteDao.findById(responseDto.getDocente()).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro al docente")
        ));
        responseDto.getEstudiantes().forEach(
                estudiante -> {
                    EstudianteEntity estudianteEntity = estudianteDao.findById(estudiante).orElseThrow(
                            () -> new ExcepcionSinDatos("No se encontro al estudiante '" + estudiante + "'.")
                    );
                    entity.getEstudiantes().add(estudianteEntity);
                }
        );

        responseDto.getEstrategias().forEach(
                estrategia -> {
                    EstrategiaEntity estrategiaEntity = estrategiaDao.findById(estrategia).orElseThrow(
                            () -> new ExcepcionSinDatos("No se encontro la estrategia '" + estrategia + "'.")
                    );
                    entity.getEstrategias().add(estrategiaEntity);
                }
        );
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());

        return entity;
    }
}
