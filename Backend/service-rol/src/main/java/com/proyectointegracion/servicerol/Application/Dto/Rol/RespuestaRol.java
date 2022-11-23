package com.proyectointegracion.servicerol.Application.Dto.Rol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.servicerol.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.servicerol.Domain.Entities.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaRol extends Respuesta {

    @JsonProperty("dato")
    Rol data;
}
