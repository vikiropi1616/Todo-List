package com.example.spring.todolist.repositorio;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.todolist.models.usuario;

public interface usuarioRepositorio extends JpaRepository<usuario, Long>{

    Optional<usuario> findById(Long id);
    
} 
