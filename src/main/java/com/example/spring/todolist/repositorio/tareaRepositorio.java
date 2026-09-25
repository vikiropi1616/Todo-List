package com.example.spring.todolist.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.todolist.models.tarea;
import com.example.spring.todolist.models.usuario;

public interface tareaRepositorio extends JpaRepository<tarea, Long> {
    
 List<tarea> findByUsuario(usuario Usuario);
}
