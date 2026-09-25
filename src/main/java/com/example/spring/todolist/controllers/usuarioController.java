package com.example.spring.todolist.controllers;

import com.example.spring.todolist.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring.todolist.models.tarea;
import com.example.spring.todolist.models.usuario;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class usuarioController {

   private final UsuarioService usuarioService;


    usuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

   @GetMapping("/conectarse")
   public String mostrarLogin(HttpSession session)
   {
    if (session.getAttribute("usuario") != null){

        return "redirect:/tareas";

    }

     return "conectarse";
   }

   //desconectarse

   @PostMapping("/desconectarse")
   public String desconectarse(HttpSession session){

        session.invalidate();

        return "redirect:/conectarse";
   }
   

  @PostMapping("/conectarse")
      public String iniciarSesion(
        @RequestParam String email,
        @RequestParam String contrasenya,
        HttpSession session) {

    Optional<usuario> usuario = usuarioService.buscarPorEmail(email);

    if (usuario.isPresent() &&
        usuario.get().getContrasenya().equals(contrasenya)) {

        session.setAttribute("usuario", usuario.get());

        return "redirect:/tareas";
    }

    return "redirect:/conectarse?error";
}
    @GetMapping("/registrarse")
public String mostrarFormulario(Model modelo) {
    modelo.addAttribute("usuario", new usuario());
    return "registrarse";
}

@PostMapping("/registrarse")
public String crearUsuario(@ModelAttribute usuario Usuario) {
    usuarioService.registrar(Usuario);
    return "redirect:/tareas";
}

}
