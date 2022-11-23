package com.proyectointegracion.servicerol.Domain.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class Estudiante extends Usuario  {


    private Date fechaNacimiento;


    private String direccion;


    private String correo;


    private String telefono;


    private String nombreApoderado;


    private Integer idGrado;

    public Estudiante() {
    }
}
