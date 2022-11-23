package com.proyectointegracion.serviceyear.Domain.Repositories;

import com.proyectointegracion.serviceyear.Domain.Entities.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository  extends JpaRepository<Year, Integer> {
}
