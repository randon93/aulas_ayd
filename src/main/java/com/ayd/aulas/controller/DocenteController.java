package com.ayd.aulas.controller;

import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.service.docente.DocenteServiceCrear;
import com.ayd.aulas.service.docente.DocenteServiceEliminar;
import com.ayd.aulas.service.docente.DocenteServiceListar;
import com.ayd.aulas.service.docente.DocenteServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteServiceModificar docenteServiceModificar;

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody DocenteDto docenteDto){
        docenteServiceModificar.ejecutar(docenteDto);
    }

    @Autowired
    private DocenteServiceEliminar docenteServiceEliminar;

    @DeleteMapping("/eliminar/{id}")
    private void eliminar(@PathVariable Long id) {
        docenteServiceEliminar.ejectar(id);
    }

    @Autowired
    private DocenteServiceListar docenteServiceListar;

    @GetMapping("/listar-todo")
    @ResponseBody
    public List<DocenteDto> listarTodo(){
        return docenteServiceListar.ejecutar();
    }

    @Autowired
    private DocenteServiceCrear docenteServiceCrear;

    @PostMapping("/crear")
    @ResponseBody
    private Long crear(@RequestBody DocenteDto docenteDto){
        return docenteServiceCrear.ejecutar(docenteDto);
    }
}
