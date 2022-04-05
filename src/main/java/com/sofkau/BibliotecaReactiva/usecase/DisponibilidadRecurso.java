package com.sofkau.BibliotecaReactiva.usecase;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DisponibilidadRecurso {
    public Mono<String> apply(String titulo);
}
