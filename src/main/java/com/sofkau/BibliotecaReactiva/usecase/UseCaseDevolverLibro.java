package com.sofkau.BibliotecaReactiva.usecase;

import com.sofkau.BibliotecaReactiva.collections.libros;
import com.sofkau.BibliotecaReactiva.dto.LibroMapper;
import com.sofkau.BibliotecaReactiva.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseDevolverLibro implements DisponibilidadRecurso{
    private final RepositorioRecurso repositorio;
    private final LibroMapper mapperUtils;
    private final UseCaseModificarLibros useCaseModificarLibros;
    @Autowired
    public UseCaseDevolverLibro(LibroMapper mapperUtils, RepositorioRecurso repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
        this.useCaseModificarLibros = new UseCaseModificarLibros(mapperUtils,repositorio);
    }

    @Override
    public Mono<String> apply(String id) {
        Mono<libros> recursoMono = repositorio.findById(id);
        return recursoMono.flatMap(recurso -> {
            if(recurso.isPrestado()){
                recurso.setPrestado(!recurso.isPrestado());
                return repositorio.save(recurso).thenReturn("Recurso devuelto");
            }
            return Mono.just("No se puede devolver. Esta prestado");
        });
    }
}
