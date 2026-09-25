package com.example.spring.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.todolist.models.tarea;
import com.example.spring.todolist.models.usuario;
import com.example.spring.todolist.repositorio.tareaRepositorio;
import com.example.spring.todolist.repositorio.usuarioRepositorio;

@Service
public class UsuarioService {
    
   
    
      private final usuarioRepositorio UsuarioRepositorio;

    public UsuarioService(usuarioRepositorio UsuarioRepositorio){
        this.UsuarioRepositorio = UsuarioRepositorio;
    }

    public usuario registrar(usuario Usuario){
        return UsuarioRepositorio.save(Usuario);
    }

    public List<usuario> obtenerTodas(){
        
        return UsuarioRepositorio.findAll();
    }

    public Optional<usuario> buscarPorId(Long id){

        return UsuarioRepositorio.findById(id);
    }

    public void eliminar(Long id){
        UsuarioRepositorio.deleteById(id);
    }

     public Optional<usuario> buscarPorEmail(String email) {
    return UsuarioRepositorio.findByEmail(email);
}

}
