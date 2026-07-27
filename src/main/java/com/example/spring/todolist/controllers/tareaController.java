package com.example.spring.todolist.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring.todolist.models.tarea;
import com.example.spring.todolist.services.TareaService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class tareaController {

    private final TareaService tareaService;

    public tareaController(TareaService tareaService){
        this.tareaService = tareaService;
    }

    //model sirve para preparar los datos para Thymeleaf nuestra plantilla visual
    @GetMapping("/tareas")
    public String mostrarTareas(Model modelo){

        modelo.addAttribute("tareas", tareaService.obtenerTodas());

        return "tareas";
        
    }

    @GetMapping("/tareas/editar/{id}")

    //@PathVariable proporciona la id para la ruta
    public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo){

        tarea Tarea = tareaService.buscarPorId(id);

        modelo.addAttribute("tarea", Tarea);

        return "editarTarea";
    }

    @PostMapping("/tareas/editar")
    public String editarTarea(@ModelAttribute tarea Tarea){

    tareaService.guardar(Tarea);

    return "redirect:/tareas";
    }

    @GetMapping("/tareas/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id, Model modelo)
    {
        tareaService.eliminar(id);

        return "redirect:/tareas";
    }

    
    //al entrar en la dirección /tareas/nuevas me llevará a la página
    //crearTarea
    @GetMapping("/tareas/nueva")
    public String mostrarFormulario(Model modelo){

        modelo.addAttribute("tarea", new tarea());

        return "crearTarea";
    }


    @PostMapping("/tareas")
    public String crearTarea(@ModelAttribute tarea Tarea){

        tareaService.guardar(Tarea);
        return "redirect:/tareas";
        
    }
    
    
    
    

}
