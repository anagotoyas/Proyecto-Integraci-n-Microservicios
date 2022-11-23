package com.proyectointegracion.serviceasistencia.Application.Dto.RegistroAsistencia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceasistencia.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceasistencia.Domain.Entities.RegistroAsistencia;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaRegistroList extends Respuesta {

    @JsonProperty("datos")
    List<RegistroAsistencia> data;
}
