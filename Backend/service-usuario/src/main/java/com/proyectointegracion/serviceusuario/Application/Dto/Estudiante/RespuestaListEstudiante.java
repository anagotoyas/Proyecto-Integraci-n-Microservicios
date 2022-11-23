package com.proyectointegracion.serviceusuario.Application.Dto.Estudiante;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Estudiante;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListEstudiante extends Respuesta {

    @JsonProperty("dato")
    List<Estudiante> data;

}
