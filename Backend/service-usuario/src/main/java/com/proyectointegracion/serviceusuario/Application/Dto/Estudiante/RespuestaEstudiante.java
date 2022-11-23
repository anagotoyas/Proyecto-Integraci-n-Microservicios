package com.proyectointegracion.serviceusuario.Application.Dto.Estudiante;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Estudiante;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaEstudiante extends Respuesta {

    @JsonProperty("dato")
    Estudiante data;

}
