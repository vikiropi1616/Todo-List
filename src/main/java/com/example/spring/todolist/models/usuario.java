package com.example.spring.todolist.models;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuarios")
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String email;
    private String contrasenya;
    private LocalDate fechaRegistro;

    //relación de entidad de 1 a N 
    @OneToMany(mappedBy = "usuario")
    private List<tarea> tareas;

    public usuario(){

    }

    public usuario(String nombre, String email, String contrasenya){

        this.nombre = nombre;
        this.email = email;
        this.contrasenya = contrasenya;
    }

    @PrePersist
    public void PrePersist()
    {
        this.fechaRegistro = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<tarea> tareas) {
        this.tareas = tareas;
    }

    
}
