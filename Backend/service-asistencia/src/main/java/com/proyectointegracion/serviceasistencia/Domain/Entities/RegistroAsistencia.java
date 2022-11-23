package com.proyectointegracion.serviceasistencia.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "registros_asistencias")
@Getter
@Setter
@ToString
public class RegistroAsistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;

    @NotNull
    @Size(min=3,max=20)
    @Column(name = "estado", nullable = false)
    private String estado;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha",nullable = false)
    private Date fecha;

    private Integer idUsuario;
    private Integer idBimestre;


    @PrePersist
    public void onCreate() {
        fecha = new Date();
    }
}
