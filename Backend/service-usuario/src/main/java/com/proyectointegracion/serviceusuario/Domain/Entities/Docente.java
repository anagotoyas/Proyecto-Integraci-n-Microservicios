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
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "docentes")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Docente extends Usuario{


    @NotNull
    @Column(name = "id_grado", nullable = false)
    private Integer idGrado;

}
