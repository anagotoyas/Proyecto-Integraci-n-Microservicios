package com.proyectointegracion.serviceusuario.Application.Dto.Docente;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Docente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListDocente extends Respuesta {

    @JsonProperty("dato")
    List<Docente> data;

}
