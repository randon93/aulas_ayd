package com.ayd.aulas.dto;

import lombok.Data;

@Data
public class EstudianteDto {

    private Long id;
    private boolean repitente;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private GrupoDto grupoDto;
}
