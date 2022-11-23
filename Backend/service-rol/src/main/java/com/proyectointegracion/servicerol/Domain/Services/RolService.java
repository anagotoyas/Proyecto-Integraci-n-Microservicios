package com.proyectointegracion.servicerol.Domain.Services;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectointegracion.servicerol.Domain.Entities.Rol;
import com.proyectointegracion.servicerol.Domain.Models.Usuario;
import com.proyectointegracion.servicerol.Domain.Repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class RolService {
    private final RolRepository rolRepository;

    @Autowired
    private RestTemplate restTemplate;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }



    public Usuario[] getUsuariosPoridRol(int idRol){

        Usuario[] registros = restTemplate.getForObject("http://localhost:8095/usuarios/rol/"+idRol,  Usuario[].class );

        return registros;
    }

    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol modificarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void eliminarRol(Integer idRol) {
        rolRepository.deleteById(idRol);
    }

    public List<Rol> listarRol() {
        return rolRepository.findAll();
    }

    public Rol obtenerRolPorIdRol(Integer idRol) {
        return rolRepository.findById(idRol).orElse(new Rol());
    }
}
