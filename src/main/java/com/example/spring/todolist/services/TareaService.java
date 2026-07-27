package com.example.spring.todolist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.todolist.models.tarea;
import com.example.spring.todolist.repositorio.tareaRepositorio;

@Service
public class TareaService {

    private final tareaRepositorio TareaRepositorio;

    public TareaService(tareaRepositorio TareaRepositorio){
        this.TareaRepositorio = TareaRepositorio;
    }

    //hace una lista de todas las tareas y las devuelve
    public List<tarea> obtenerTodas(){
        
        return TareaRepositorio.findAll();
    }

    //guarda una tarea
    public tarea guardar(tarea Tarea){
        return TareaRepositorio.save(Tarea);
    }

    public tarea buscarPorId(Long id){
        return TareaRepositorio.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        TareaRepositorio.deleteById(id);
    }

}
