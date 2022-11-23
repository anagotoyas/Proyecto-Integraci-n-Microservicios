package com.proyectointegracion.serviceasistencia.Application.Controllers;

import com.proyectointegracion.serviceasistencia.Application.Dto.RegistroAsistencia.RespuestaRegistro;
import com.proyectointegracion.serviceasistencia.Application.Dto.RegistroAsistencia.RespuestaRegistroList;
import com.proyectointegracion.serviceasistencia.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceasistencia.Domain.Entities.RegistroAsistencia;
import com.proyectointegracion.serviceasistencia.Domain.Services.RegistroAsistenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroAsistenciaController {

    Boolean satis=false;


    private final RegistroAsistenciaService registroAsistenciaService;

    public RegistroAsistenciaController(RegistroAsistenciaService registroAsistenciaService) {

        this.registroAsistenciaService = registroAsistenciaService;
    }

    @PostMapping
    public ResponseEntity<RespuestaRegistro> crearRegistro(@Valid @RequestBody RegistroAsistencia registroAsistencia){
        RespuestaRegistro respuesta = new RespuestaRegistro();

        try{

            if(registroAsistencia!=null){
                satis=true;
            }
            else{
                satis=false;
            }
            RegistroAsistencia registronew = registroAsistenciaService.crearRegistro(registroAsistencia);
            respuesta.setMensaje("Registo de asistencia creado ");
            respuesta.setSatisfactorio(satis);
            respuesta.setCodigo("200");
            respuesta.setData(registronew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("Registo de asistencia creado con fallido"+e);
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }


    }
    @PutMapping
    public ResponseEntity<RespuestaRegistro> modificarRegistro(@Valid @RequestBody RegistroAsistencia registroAsistencia){
        RespuestaRegistro respuesta = new RespuestaRegistro();
        try{
            RegistroAsistencia registroUpdate = registroAsistenciaService.modificarRegistro(registroAsistencia);
            respuesta.setMensaje("Registo de asistencia modificado con éxito");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(registroUpdate);

            return new ResponseEntity<>(respuesta,HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("Registo de asistencia creado con fallido");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }


    }
    @DeleteMapping("/{idRegistro}")
    public ResponseEntity<Respuesta> eliminarRegistro(@PathVariable("idRegistro") Integer idRegistro){

        Respuesta respuesta = new Respuesta();

        try{
            registroAsistenciaService.eliminarRegistro(idRegistro);
            respuesta.setMensaje("Registro de asistencia eliminado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("Registro de asistencia eliminado fallido");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
    public ResponseEntity<RespuestaRegistroList> listarRegistro(){
        RespuestaRegistroList respuesta = new RespuestaRegistroList();

        try{
            List<RegistroAsistencia> registros = registroAsistenciaService.listarRegistros();
            respuesta.setMensaje("Registro de asistencia listados con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(registros);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("Registro de asistencia listados fallido");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{idRegistro}")
    public ResponseEntity<RespuestaRegistro> obtenerRegistroPorId(@PathVariable ("idRegistro") Integer idRegistro){
        RespuestaRegistro respuesta=new RespuestaRegistro();

        try{
            RegistroAsistencia registroAsistencia = registroAsistenciaService.obtenerRegistroPorId(idRegistro);

            respuesta.setMensaje("Registro encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(registroAsistencia);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){
            respuesta.setMensaje("Registro de asistencia no encontrado");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<RegistroAsistencia>> obtenerRegistrosPorUsuario(@PathVariable Integer idUsuario) {

        List<RegistroAsistencia> registros = registroAsistenciaService.listarRegistrosPorusuario(idUsuario);
        return new ResponseEntity<>(registros, HttpStatus.OK);

    }




}