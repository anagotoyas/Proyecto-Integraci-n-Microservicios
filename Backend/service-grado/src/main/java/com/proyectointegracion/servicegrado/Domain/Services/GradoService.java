package com.proyectointegracion.servicegrado.Domain.Services;

import com.proyectointegracion.servicegrado.Domain.Entities.Grado;
import com.proyectointegracion.servicegrado.Domain.Model.Estudiante;
import com.proyectointegracion.servicegrado.Domain.Repositories.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GradoService {

    private final GradoRepository gradoRepository;

    @Autowired
    private RestTemplate restTemplate;

    public GradoService(GradoRepository gradoRepository) {
        this.gradoRepository = gradoRepository;
    }

    public Estudiante[] getUsuariosPoridGrado(int idGrado){

        Estudiante[] registros = restTemplate.getForObject("http://localhost:8095/estudiantes/grado/"+idGrado,  Estudiante[].class );

        return registros;
    }

    public Grado crearRol(Grado grado) {
        return gradoRepository.save(grado);
    }

    public Grado modificarGrado(Grado grado) {
        return gradoRepository.save(grado);
    }

    public void eliminarGrado(Integer idGrado) {
        gradoRepository.deleteById(idGrado);
    }

    public List<Grado> listarGrado() {
        return gradoRepository.findAll();
    }

    public Grado obtenerGradoPorIdGrado(Integer idGrado) {
        return gradoRepository.findById(idGrado).orElse(new Grado());
    }
    public List<Grado> findAllByIdYear(Integer idYear){
        return gradoRepository.findAllByIdYear(idYear);
    }
}
