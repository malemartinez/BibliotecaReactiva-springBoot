package com.sofkau.BibliotecaReactiva.usecase;

import com.sofkau.BibliotecaReactiva.dto.LibroDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AgregarRecurso {
    public Mono<LibroDto> apply(LibroDto libroDto);
}

