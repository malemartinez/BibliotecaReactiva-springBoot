package com.sofkau.BibliotecaReactiva.usecase;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface BorarRecurso {
    public Mono<Void> get(String id);
}
