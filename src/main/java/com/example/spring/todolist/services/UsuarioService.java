package com.example.spring.todolist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.todolist.models.usuario;
import com.example.spring.todolist.repositorio.usuarioRepositorio;

@Service
public class UsuarioService {
    
    @Autowired
    private usuarioRepositorio UsuarioRepositorio;

    public usuario registrar(usuario Usuario){
        return UsuarioRepositorio.save(Usuario);
    }

    public Optional<usuario> buscarPorId(Long id){

        return UsuarioRepositorio.findById(id);
    }
}
