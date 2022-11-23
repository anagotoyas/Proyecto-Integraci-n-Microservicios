package com.proyectointegracion.serviceusuario.Application.Controllers;

import com.proyectointegracion.serviceusuario.Application.Dto.Estudiante.RespuestaEstudiante;
import com.proyectointegracion.serviceusuario.Application.Dto.Estudiante.RespuestaListEstudiante;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Estudiante;
import com.proyectointegracion.serviceusuario.Domain.Entities.Usuario;
import com.proyectointegracion.serviceusuario.Domain.Services.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {


    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<RespuestaEstudiante> crearRol(@Valid @RequestBody Estudiante estudiante) {

        RespuestaEstudiante respuesta = new RespuestaEstudiante();

        try {
            Estudiante estudianteNew = estudianteService.crearEstudiante(estudiante);

            respuesta.setMensaje("Estudiante creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudianteNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<RespuestaEstudiante> modificarEstudiante(@Valid @RequestBody Estudiante estudiante){

        RespuestaEstudiante respuesta = new RespuestaEstudiante();

        try {
            Estudiante estudianteUpdate = estudianteService.modificarEstudiante(estudiante);

            respuesta.setMensaje("Estudiante modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudianteUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idEstudiante}")
    public ResponseEntity<Respuesta> eliminarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante){


        Respuesta respuesta = new Respuesta();

        try {

            estudianteService.eliminarEstudiante(idEstudiante);

            respuesta.setMensaje("Estudiante eliminado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<RespuestaListEstudiante> listarEstudiante(){

        RespuestaListEstudiante respuesta = new RespuestaListEstudiante();

        try {
            List<Estudiante> estudiantes = estudianteService.listarEstudiantes();

            respuesta.setMensaje("Lista de estudiantes llamada con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudiantes);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idEstudiante}")
    public ResponseEntity<RespuestaEstudiante> obtenerRolPorIdRol(@PathVariable("idEstudiante") Integer idEstudiante){

        RespuestaEstudiante respuesta = new RespuestaEstudiante();

        try {
            Estudiante estudiante = estudianteService.obtenerEstudiantePorId(idEstudiante);

            respuesta.setMensaje("Estudiante encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(estudiante);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/grado/{idGrado}")
    public ResponseEntity<List<Estudiante>> obtenerUsuariosPorRol(@PathVariable Integer idGrado) {

        List<Estudiante> estudiantes = estudianteService.findUsuarioByGrado(idGrado);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);

    }



}
