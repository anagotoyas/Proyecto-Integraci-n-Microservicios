package com.proyectointegracion.servicebimestre.Domain.Repositories;

import com.proyectointegracion.servicebimestre.Domain.Entities.Bimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BimestreRepository extends JpaRepository<Bimestre, Integer> {

    List<Bimestre> findAllByIdYear(Integer idYear);
}
