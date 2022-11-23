package com.proyectointegracion.serviceusuario.Application.Dto.Admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Admin;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListAdmin extends Respuesta {

    @JsonProperty("dato")
    List<Admin> data;

}
