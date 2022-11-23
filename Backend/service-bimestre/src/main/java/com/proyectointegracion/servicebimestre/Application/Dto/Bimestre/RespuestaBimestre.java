package com.proyectointegracion.servicebimestre.Application.Dto.Bimestre;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.servicebimestre.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.servicebimestre.Domain.Entities.Bimestre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaBimestre extends Respuesta {

    @JsonProperty("dato")
    Bimestre data;
}
