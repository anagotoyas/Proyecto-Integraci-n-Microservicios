package com.proyectointegracion.serviceusuario.Application.Dto.Docente;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Docente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaDocente extends Respuesta {

    @JsonProperty("dato")
    Docente data;

}