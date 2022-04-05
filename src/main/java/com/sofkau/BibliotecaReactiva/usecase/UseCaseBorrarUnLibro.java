package com.sofkau.BibliotecaReactiva.usecase;

import com.sofkau.BibliotecaReactiva.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UseCaseBorrarUnLibro implements BorarRecurso {
    private final RepositorioRecurso repositorio;
    @Autowired
    public UseCaseBorrarUnLibro(RepositorioRecurso repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Mono get(String id) {
        if (Objects.isNull(id)) {
            return Mono.empty();
        }
        return repositorio.deleteById(id);
    }
}
