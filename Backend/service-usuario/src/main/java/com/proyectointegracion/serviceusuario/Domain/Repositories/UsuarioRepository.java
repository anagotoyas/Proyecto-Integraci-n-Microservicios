package com.proyectointegracion.serviceusuario.Domain.Repositories;

import com.proyectointegracion.serviceusuario.Domain.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findUsuarioByIdUsuarioAndClave(Integer idUsuario, String clave);

    //@Query("SELECT u FROM Usuario u WHERE u.idRol=:idRol")
    //List<Usuario> findAllByRol(@Param("idRol") Integer idRol);

    List<Usuario> findAllByIdRol(Integer idRol);

    Usuario findUsuarioByIdRolAndIdUsuario(Integer idUsuario, Integer idRol);


}
