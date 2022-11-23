package com.proyectointegracion.servicebimestre.Application.Dto.Bimestre;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.servicebimestre.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.servicebimestre.Domain.Entities.Bimestre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListBimestre extends Respuesta {

    @JsonProperty("dato")
    List<Bimestre> data;
}
