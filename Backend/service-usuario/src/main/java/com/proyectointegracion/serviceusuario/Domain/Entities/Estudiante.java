package com.proyectointegracion.serviceusuario.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Table(name = "estudiantes")
@Getter
@Setter
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Estudiante extends Usuario  {


    @NotNull
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @NotNull
    @Column(name = "correo", nullable = true)
    private String correo;

    @NotNull
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @NotNull
    @Column(name = "nombre_apoderado", nullable = false)
    private String nombreApoderado;

    @NotNull
    @Column(name = "id_grado", nullable = false)
    private Integer idGrado;

}
