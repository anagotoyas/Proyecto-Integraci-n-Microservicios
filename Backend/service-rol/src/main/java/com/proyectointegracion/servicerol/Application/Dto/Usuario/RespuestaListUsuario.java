package com.proyectointegracion.servicerol.Application.Dto.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.servicerol.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.servicerol.Domain.Entities.Rol;
import com.proyectointegracion.servicerol.Domain.Models.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListUsuario extends Respuesta {
    @JsonProperty("dato")
    List<Usuario> data;
}
