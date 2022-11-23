package com.proyectointegracion.serviceusuario.Domain.Services;

import com.proyectointegracion.serviceusuario.Domain.Entities.Estudiante;
import com.proyectointegracion.serviceusuario.Domain.Entities.Usuario;
import com.proyectointegracion.serviceusuario.Domain.Repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;


    public EstudianteService(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;

    }
    public List<Estudiante> findUsuarioByGrado(Integer idGrado){
        return estudianteRepository.findAllByIdGrado(idGrado);
    }

    public Estudiante crearEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Estudiante modificarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(Integer idEstudiante){
        estudianteRepository.deleteById(idEstudiante);
    }

    public List<Estudiante> listarEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Integer idEstudiante){
        return estudianteRepository.findById(idEstudiante).orElse(new Estudiante());
    }

}