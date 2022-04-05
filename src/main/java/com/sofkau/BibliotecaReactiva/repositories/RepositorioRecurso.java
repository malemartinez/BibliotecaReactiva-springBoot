package com.sofkau.BibliotecaReactiva.repositories;

import com.sofkau.BibliotecaReactiva.collections.libros;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRecurso extends ReactiveMongoRepository<libros, String> {
}

