package com.proyectointegracion.servicerol.Domain.Entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.serializer.Serializer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idRol;

    @NotNull
    @Size(min=3,max=50, message="El nombre debe ser minimo 3 caracteres y máximo 50.")
    @Column(name="nombre_rol", nullable = false)
    private String nombreRol;
}

