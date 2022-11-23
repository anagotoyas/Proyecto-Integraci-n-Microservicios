package com.proyectointegracion.serviceusuario.Application.Controllers;

import com.proyectointegracion.serviceusuario.Application.Dto.Docente.RespuestaDocente;
import com.proyectointegracion.serviceusuario.Application.Dto.Docente.RespuestaListDocente;
import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Domain.Entities.Docente;
import com.proyectointegracion.serviceusuario.Domain.Services.DocenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/docentes")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService){
        this.docenteService = docenteService;
    }

    @PostMapping
    public ResponseEntity<RespuestaDocente> registrarDocente(@Valid @RequestBody Docente docente){
        RespuestaDocente respuesta = new RespuestaDocente();

        try{
            Docente docente1 = docenteService.crearDocente(docente);

            respuesta.setMensaje("Docente creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(docente1);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaDocente> modificarDocente(@Valid @RequestBody Docente docente){
        RespuestaDocente respuesta = new RespuestaDocente();

        try{
            Docente docente1 = docenteService.modificarDocente(docente);

            respuesta.setMensaje("Docente modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(docente1);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idDocente}")
    public ResponseEntity<Respuesta> eliminarDocente(@PathVariable("idDocente") Integer idDocente){
        Respuesta respuesta = new Respuesta();

        try{
            docenteService.eliminarDocente(idDocente);

            respuesta.setMensaje("Docente eliminado con éxito.");
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
    public ResponseEntity<RespuestaListDocente> listarDocentes(){

        RespuestaListDocente respuesta = new RespuestaListDocente();

        try {
            List<Docente> docentes = docenteService.listarDocentes();

            respuesta.setMensaje("Docentes listados con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(docentes);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idDocente}")
    public ResponseEntity<RespuestaDocente> obtenerDocentePorId(@PathVariable("idDocente") Integer idDocente){
        RespuestaDocente respuesta = new RespuestaDocente();

        try {
            Docente docente = docenteService.obtenerDocentePorId(idDocente);

            respuesta.setMensaje("Docente encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(docente);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

}
