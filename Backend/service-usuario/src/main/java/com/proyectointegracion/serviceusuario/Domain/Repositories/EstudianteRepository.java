package com.proyectointegracion.serviceusuario.Domain.Repositories;

import com.proyectointegracion.serviceusuario.Domain.Entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    List<Estudiante> findAllByIdGrado(Integer idGrado);

}
