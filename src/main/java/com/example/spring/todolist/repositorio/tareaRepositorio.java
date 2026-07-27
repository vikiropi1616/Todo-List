package com.example.spring.todolist.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.todolist.models.tarea;

public interface tareaRepositorio extends JpaRepository<tarea, Long> {
    

}
