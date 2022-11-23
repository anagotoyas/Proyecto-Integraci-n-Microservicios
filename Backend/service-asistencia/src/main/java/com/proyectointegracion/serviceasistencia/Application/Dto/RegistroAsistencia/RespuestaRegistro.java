package com.proyectointegracion.serviceasistencia.Application.Dto.RegistroAsistencia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceasistencia.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceasistencia.Domain.Entities.RegistroAsistencia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaRegistro extends Respuesta {

    @JsonProperty("dato")
    RegistroAsistencia data;
}
