package com.proyectointegracion.serviceyear.Domain.Entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "years")
public class Year {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idYear;

    @NotNull
    @Column(name="year", nullable = false)
    private Integer year;
}
