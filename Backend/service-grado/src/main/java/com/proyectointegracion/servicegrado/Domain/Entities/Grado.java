package com.proyectointegracion.servicegrado.Domain.Entities;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name="grados")
public class Grado {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idGrado;

    @NotNull
    @Size(min=3,max=50, message="El nombre debe ser minimo 3 caracteres y máximo 50.")
    @Column(name="nombre_grado", nullable = false)
    private String nombreGrado;

    @NotNull
    @Column(name="id_year", nullable = false)
    private Integer idYear;



}
