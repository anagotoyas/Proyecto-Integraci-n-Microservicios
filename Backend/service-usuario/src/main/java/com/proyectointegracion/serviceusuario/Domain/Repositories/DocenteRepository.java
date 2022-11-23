package com.proyectointegracion.serviceusuario.Domain.Repositories;

import com.proyectointegracion.serviceusuario.Domain.Entities.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {

}
