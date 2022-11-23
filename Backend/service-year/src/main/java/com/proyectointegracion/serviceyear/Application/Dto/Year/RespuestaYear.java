package com.proyectointegracion.serviceyear.Application.Dto.Year;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceyear.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceyear.Domain.Entities.Year;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaYear extends Respuesta {

    @JsonProperty("dato")
    Year data;
}
