package com.ayd.aulas.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EstrategiaDto {

    private Long id;
    private String nombre;
    private Date creacion;
    private String documento;
}
