package com.proyectointegracion.serviceasistencia.Domain.Services;

import com.proyectointegracion.serviceasistencia.Application.Dto.RegistroAsistencia.RespuestaRegistro;
import com.proyectointegracion.serviceasistencia.Domain.Entities.RegistroAsistencia;
import com.proyectointegracion.serviceasistencia.Domain.Models.Usuario;
import com.proyectointegracion.serviceasistencia.Domain.Repositories.RegistroAsistenciaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class RegistroAsistenciaService {

    @Autowired
    private final RegistroAsistenciaRepository registroAsistenciaRepository;

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private RestTemplate restTemplate;


    public RegistroAsistenciaService(RegistroAsistenciaRepository registroAsistenciaRepository) {
        this.registroAsistenciaRepository = registroAsistenciaRepository;
    }



    public RegistroAsistencia crearRegistro(RegistroAsistencia registroAsistencia) throws InterruptedException {

        Integer idUser=registroAsistencia.getIdUsuario();
        Usuario user= restTemplate.getForObject("http://localhost:8095/usuarios/"+idUser, Usuario.class);

        RegistroAsistencia res=null;

        if(user!=null){

            Integer idRol=2;
            Boolean respuesta= restTemplate.getForObject("http://localhost:8095/usuarios/comprobar/"+idRol+"/id/"+idUser,Boolean.class );
            if (respuesta==true){
                res=registroAsistenciaRepository.save(registroAsistencia);

            }
        }
        else {
            logger.error("Error en la respuesta del servicio invocado. Code:" );
            throw new InterruptedException("Error en la respuesta del servicio invocado. Code:");
        }


        return res;
    }





    public RegistroAsistencia modificarRegistro(RegistroAsistencia registroAsistencia) {
        return registroAsistenciaRepository.save(registroAsistencia);
    }

    public void eliminarRegistro(Integer idRegistro) {
        registroAsistenciaRepository.deleteById(idRegistro);
    }


    public List<RegistroAsistencia> listarRegistros() {
        return registroAsistenciaRepository.findAll();
    }

    public List<RegistroAsistencia> listarRegistrosPorusuario(Integer idUsuario) {
        return registroAsistenciaRepository.findAllByIdUsuario(idUsuario);
    }


    public RegistroAsistencia obtenerRegistroPorId(Integer idRegistro) {
        return registroAsistenciaRepository.findById(idRegistro).orElse(new RegistroAsistencia());
    }
}