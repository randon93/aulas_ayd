package com.ayd.aulas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @GetMapping("/hola")
    public void hola(){

    }
}
