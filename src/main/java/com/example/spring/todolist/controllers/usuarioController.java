package com.example.spring.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.spring.todolist.models.usuario;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class usuarioController {

   @GetMapping("/conectarse")
   public String mostrarLogin()
   {
     return "conectarse";
   }

   
   

}
