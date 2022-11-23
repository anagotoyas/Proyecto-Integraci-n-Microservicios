package com.proyectointegracion.serviceusuario.Domain.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Admin extends Usuario{


}
