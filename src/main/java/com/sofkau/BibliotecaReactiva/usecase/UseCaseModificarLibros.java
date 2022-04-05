package com.sofkau.BibliotecaReactiva.usecase;

import com.sofkau.BibliotecaReactiva.dto.LibroDto;
import com.sofkau.BibliotecaReactiva.dto.LibroMapper;
import com.sofkau.BibliotecaReactiva.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseModificarLibros implements AgregarRecurso{
    private final RepositorioRecurso repositorio;
    private final LibroMapper mapperUtils;
    @Autowired
    public UseCaseModificarLibros(LibroMapper mapperUtils, RepositorioRecurso repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<LibroDto> apply(LibroDto libroDto) {
        String id = libroDto.getId();
        if (id == null){
            new RuntimeException("El id es requerido");
        }
        return repositorio.save(mapperUtils.mapperToDato(libroDto.getId()).apply(libroDto)).map(mapperUtils.mapDatoToDTO());
    }
}
