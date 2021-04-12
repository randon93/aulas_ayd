package com.ayd.aulas.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "estrategia")
public class EstrategiaEntity {

    @Id
    private Long id;
    private Date creacion;
    private String documento;
}
