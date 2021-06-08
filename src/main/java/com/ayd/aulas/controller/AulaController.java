package com.ayd.aulas.controller;

import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.service.aula.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaServiceModificar aulaServiceModificar;

    @Autowired
    private AulaServiceListar aulaServiceListar;

    @Autowired
    private AulaServiceEliminar aulaServiceEliminar;

    @Autowired
    private AulaServiceConsultar aulaServiceConsultar;

    @Autowired
    private AulaServiceCrear aulaServiceCrear;

    @PostMapping("/crear")
    @ResponseBody
    public Long crear(@RequestBody AulaDto aulaDto){
        return aulaServiceCrear.ejecutar(aulaDto);
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<AulaDto> listar(){
        return aulaServiceListar.ejecutar();
    }

    @GetMapping("/buscar-nombre")
    @ResponseBody
    public AulaDto buscarNombre(String nombre){
        return aulaServiceConsultar.ejecutar(nombre);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        aulaServiceEliminar.ejecutar(id);
    }

    @PutMapping("/actualizar")
    @ResponseBody
    void actualizar(@RequestBody AulaDto aulaDto){
        aulaServiceModificar.ejecutar(aulaDto);
    }
}
