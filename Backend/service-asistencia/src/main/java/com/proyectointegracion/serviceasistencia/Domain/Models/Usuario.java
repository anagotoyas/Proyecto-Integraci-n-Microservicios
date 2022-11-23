package com.proyectointegracion.serviceasistencia.Domain.Models;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Usuario implements Serializable {


    private Integer idUsuario;


    private String dni;


    private String nombre;


    private String apellidoPaterno;


    private String apellidoMaterno;


    private String sexo;


    private String clave;

    private Integer idRol;



    public Usuario() {
    }
}