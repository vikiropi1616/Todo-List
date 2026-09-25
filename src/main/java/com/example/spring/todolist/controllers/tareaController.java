package com.example.spring.todolist.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring.todolist.models.tarea;
import com.example.spring.todolist.models.usuario;
import com.example.spring.todolist.services.TareaService;

import jakarta.servlet.http.HttpSession;

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
    public String mostrarTareas(Model modelo, HttpSession session){

        usuario Usuario = (usuario) session.getAttribute("usuario");

        modelo.addAttribute("tareas", tareaService.obtenerPorUsuario(Usuario));

        return "tareas";
        
    }

    @GetMapping("/tareas/editar/{id}")

    //@PathVariable proporciona la id para la ruta
    public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo, HttpSession session){

        usuario Usuario = (usuario) session.getAttribute("usuario");

        tarea Tarea = tareaService.buscarPorId(id);

        modelo.addAttribute("tarea", Tarea);

        return "editarTarea";
    }

    @PostMapping("/tareas/editar")
    public String editarTarea(@ModelAttribute tarea Tarea, HttpSession session){

     usuario Usuario = (usuario) session.getAttribute("usuario");

    tareaService.guardar(Tarea);

    return "redirect:/tareas";
    }

    @GetMapping("/tareas/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id, Model modelo, HttpSession session)
    {
         usuario Usuario = (usuario) session.getAttribute("usuario");

        tareaService.eliminar(id);

        return "redirect:/tareas";
    }

    
    //al entrar en la dirección /tareas/nuevas me llevará a la página
    //crearTarea
    @GetMapping("/tareas/nueva")
    public String mostrarFormulario(Model modelo, HttpSession session){
        
        if (session.getAttribute("usuario") == null)
        {
            return "redirect:/conectarse";
        }
        modelo.addAttribute("tarea", new tarea());

        return "crearTarea";
    }


    @PostMapping("/tareas")
    public String crearTarea(@ModelAttribute tarea Tarea, HttpSession session){

        usuario Usuario = (usuario) session.getAttribute("usuario");
        if(Usuario == null)
        {
            return "redirect:/conectarse";
        }
        Tarea.setUsuario(Usuario);

        tareaService.guardar(Tarea);

        return "redirect:/tareas";
        
    }
    
    
    
    
    
    
    

}
