package com.sofkau.BibliotecaReactiva.usecase;

import com.sofkau.BibliotecaReactiva.dto.LibroDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ObtenerPorId {
    public Mono<LibroDto> get(String id);
}
