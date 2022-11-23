package com.proyectointegracion.serviceusuario.Domain.Repositories;

import com.proyectointegracion.serviceusuario.Domain.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
