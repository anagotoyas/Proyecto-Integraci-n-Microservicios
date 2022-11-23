package com.proyectointegracion.serviceyear.Application.Dto.Year;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceyear.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceyear.Domain.Entities.Year;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RespuestaListYear extends Respuesta {

    @JsonProperty("dato")
    List<Year> data;
}
