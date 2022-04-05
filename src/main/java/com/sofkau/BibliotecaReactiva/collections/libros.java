package com.sofkau.BibliotecaReactiva.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "libritos")
public class libros {
    @Id
    private String id;
    private String titulo;
    private String genero;
    private String area;
    private boolean prestado = false;
    private LocalDate fechaPrestamo = null;

    public libros() {
    }

    public libros(String id, String titulo, String genero, String area, boolean prestado) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.area = area;
        this.prestado = prestado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
