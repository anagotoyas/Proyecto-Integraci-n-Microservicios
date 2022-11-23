package com.proyectointegracion.servicebimestre.Domain.Entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="bimestres")
public class Bimestre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idBimestre;

    @NotNull
    @Column(name="nombre_bimestre", nullable = false)
    private String nombreBimestre;

    @NotNull
    @Column(name="id_year", nullable = false)
    private Integer idYear;
}
