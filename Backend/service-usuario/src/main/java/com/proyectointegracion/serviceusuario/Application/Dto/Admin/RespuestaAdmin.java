package com.proyectointegracion.serviceusuario.Application.Dto.Admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Admin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaAdmin extends Respuesta {

    @JsonProperty("dato")
    Admin data;

}
