package com.proyectointegracion.servicegrado.Domain.Repositories;

import com.proyectointegracion.servicegrado.Domain.Entities.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradoRepository  extends JpaRepository<Grado, Integer> {

    List<Grado> findAllByIdYear(Integer idYear);
}
