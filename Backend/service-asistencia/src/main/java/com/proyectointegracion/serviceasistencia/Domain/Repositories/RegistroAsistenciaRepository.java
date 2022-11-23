package com.proyectointegracion.serviceasistencia.Domain.Repositories;

import com.proyectointegracion.serviceasistencia.Domain.Entities.RegistroAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroAsistenciaRepository extends JpaRepository<RegistroAsistencia, Integer> {

    List<RegistroAsistencia> findAllByIdUsuario(Integer IdUsuario);
}
