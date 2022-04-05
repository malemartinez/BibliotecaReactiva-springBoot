package com.sofkau.BibliotecaReactiva.usecase;

import com.sofkau.BibliotecaReactiva.collections.libros;
import com.sofkau.BibliotecaReactiva.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseDisponibilidadLibro implements DisponibilidadRecurso{
    private final RepositorioRecurso repositorio;
    @Autowired
    public UseCaseDisponibilidadLibro(RepositorioRecurso repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Mono<String> apply(String id) {
        Mono<libros> recursoMono = repositorio.findById(id);
        return recursoMono.map(recurso -> recurso.isPrestado() == true ?
                "Recurso no disponible, prestado el día: "+ recurso.getFechaPrestamo() : "Recurso disponible" );
    }
}
