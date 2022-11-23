package com.proyectointegracion.serviceusuario.Application.Dto.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaListUsuario extends Respuesta {
    @JsonProperty("dato")
    List<Usuario> data;

}
