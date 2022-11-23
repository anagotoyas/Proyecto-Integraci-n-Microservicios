package com.proyectointegracion.serviceusuario.Application.Dto.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaUsuario extends Respuesta {
    @JsonProperty("dato")
    Usuario data;

}
