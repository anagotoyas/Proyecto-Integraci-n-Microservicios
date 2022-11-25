package com.proyectointegracion.servicegrado.Domain.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Estudiante extends Usuario  {




    private String direccion;


    private String correo;


    private String telefono;


    private String nombreApoderado;


    private Integer idGrado;

    public Estudiante() {
    }
}
