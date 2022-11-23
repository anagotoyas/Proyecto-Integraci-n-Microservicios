package com.proyectointegracion.serviceusuario.Domain.Services;

import com.proyectointegracion.serviceusuario.Domain.Entities.Usuario;
import com.proyectointegracion.serviceusuario.Domain.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;



    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario fetchUsuarioPorIdYClave(Integer idUsuario, String clave){
        return usuarioRepository.findUsuarioByIdUsuarioAndClave(idUsuario, clave);
    }

    public Usuario fetchUsuarioPorIdRolYId( Integer idRol,Integer idUsuario){
        return usuarioRepository.findUsuarioByIdRolAndIdUsuario( idRol, idUsuario);
    }

    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario modificarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Integer idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> buscarUsuariosByRol(Integer idRol) {
        return this.usuarioRepository.findAllByIdRol(idRol);
    }

    public Usuario obtenerUsuarioPorIdUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(new Usuario());
    }


}
