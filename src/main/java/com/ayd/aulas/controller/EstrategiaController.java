package com.ayd.aulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estrategia")
public class EstrategiaController {

    @Autowired
    private EstrategiaService estrategiaService;
}
