package com.proyectointegracion.servicerol.Application.Dto.Rol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.servicerol.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.servicerol.Domain.Entities.Rol;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListRol extends Respuesta {

    @JsonProperty("dato")
    List<Rol> data;

}
