package com.proyectointegracion.serviceusuario.Application.Controllers;

import com.proyectointegracion.serviceusuario.Application.Dto.Respuestas.Respuesta;
import com.proyectointegracion.serviceusuario.Application.Dto.Usuario.RespuestaListUsuario;
import com.proyectointegracion.serviceusuario.Application.Dto.Usuario.RespuestaUsuario;
import com.proyectointegracion.serviceusuario.Domain.Entities.Usuario;
import com.proyectointegracion.serviceusuario.Domain.Services.UsuarioService;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<RespuestaUsuario> logIn (@RequestBody Usuario user) throws Exception{

        RespuestaUsuario respuesta = new RespuestaUsuario();

        try {
            Integer idUsuario= user.getIdUsuario();
            System.out.println(idUsuario);
            String clave= user.getClave();
            System.out.println(clave);
            Usuario userObj=null;
            if (idUsuario !=null && clave!= null){
                userObj=usuarioService.fetchUsuarioPorIdYClave(idUsuario,clave);
            }
            if(userObj != null){
                respuesta.setMensaje("Ha iniciado sesión con éxito");
                respuesta.setSatisfactorio(true);
                respuesta.setCodigo("200");
                respuesta.setData(userObj);
            } else {
                respuesta.setMensaje("Credenciales incorrectas.");
                respuesta.setSatisfactorio(false);
                respuesta.setCodigo("404");
                respuesta.setData(userObj);
            }

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }catch (Exception e){

            respuesta.setMensaje("No se ha podido iniciar sesión");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/comprobar/{idRol}/id/{idUsuario}")
    public ResponseEntity<Boolean> ComprobarRol (@PathVariable("idRol") Integer idRol, @PathVariable("idUsuario")Integer idUsuario) throws Exception{
        Boolean respuesta=false;


        try {
            Usuario user =usuarioService.obtenerUsuarioPorIdUsuario(idUsuario);
            if(user!=null){
                if(user.getIdRol()==idRol){
                    respuesta=true;
                }
            }


            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }catch (Exception e){



            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<RespuestaUsuario> crearRol(@Valid @RequestBody Usuario usuario) {

        RespuestaUsuario respuesta = new RespuestaUsuario();

        try {
            Usuario usuarioNew = usuarioService.crearUsuario(usuario);

            respuesta.setMensaje("Usuario creado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(usuarioNew);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<RespuestaUsuario> modificarUsuario(@Valid @RequestBody Usuario usuario){

        RespuestaUsuario respuesta = new RespuestaUsuario();

        try {
            Usuario usuarioUpdate = usuarioService.modificarUsuario(usuario);

            respuesta.setMensaje("Usuario modificado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(usuarioUpdate);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Respuesta> eliminarUsuario(@PathVariable("idUsuario") Integer idUsuario){


        Respuesta respuesta = new Respuesta();

        try {

            usuarioService.eliminarUsuario(idUsuario);

            respuesta.setMensaje("Usuario eliminado con éxito.");
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
    public ResponseEntity<RespuestaListUsuario> listarUsuarios(){

        RespuestaListUsuario respuesta = new RespuestaListUsuario();

        try {
            List<Usuario> usuarios = usuarioService.listarUsuario();

            respuesta.setMensaje("Lista de usuarios llamada con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(usuarios);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        } catch (Exception e){

            respuesta.setMensaje("failed");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<RespuestaUsuario> obtenerUsuarioPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {

        RespuestaUsuario respuesta = new RespuestaUsuario();

        try {
            Usuario usuario = usuarioService.obtenerUsuarioPorIdUsuario(idUsuario);

            respuesta.setMensaje("El usuario se ha encontrado con éxito.");
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("200");
            respuesta.setData(usuario);

            return new ResponseEntity<>(respuesta, HttpStatus.OK);

        }catch (Exception e){

            respuesta.setMensaje("El usuario no se ha encontrado con éxito.");
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("400");

            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rol/{idRol}")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPorRol(@PathVariable Integer idRol) {

            List<Usuario> usuarios = usuarioService.buscarUsuariosByRol(idRol);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);

    }




}
