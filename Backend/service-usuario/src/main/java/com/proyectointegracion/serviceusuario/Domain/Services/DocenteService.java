package com.proyectointegracion.serviceusuario.Domain.Services;

import com.proyectointegracion.serviceusuario.Domain.Entities.Docente;
import com.proyectointegracion.serviceusuario.Domain.Repositories.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository){
        this.docenteRepository = docenteRepository;
    }

    public Docente crearDocente(Docente docente){
        return docenteRepository.save(docente);
    }

    public Docente modificarDocente(Docente docente){
        return docenteRepository.save(docente);
    }

    public void eliminarDocente(Integer idDocente){
        docenteRepository.deleteById(idDocente);
    }

    public List<Docente> listarDocentes(){
        return docenteRepository.findAll();
    }

    public Docente obtenerDocentePorId(Integer idDocente){
        return docenteRepository.findById(idDocente).orElse(new Docente());
    }

}