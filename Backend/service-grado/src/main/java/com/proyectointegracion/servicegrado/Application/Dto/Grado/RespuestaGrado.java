package com.proyectointegracion.servicegrado.Application.Dto.Grado;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.servicegrado.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.servicegrado.Domain.Entities.Grado;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RespuestaGrado extends Respuesta {

    @JsonProperty("dato")
    Grado data;
}
