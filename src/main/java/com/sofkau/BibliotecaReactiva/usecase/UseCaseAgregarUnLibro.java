package com.sofkau.BibliotecaReactiva.usecase;

import com.sofkau.BibliotecaReactiva.dto.LibroDto;
import com.sofkau.BibliotecaReactiva.dto.LibroMapper;
import com.sofkau.BibliotecaReactiva.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseAgregarUnLibro implements AgregarRecurso {
    private final RepositorioRecurso repositorio;
    private final LibroMapper mapperUtils;
    //    @Autowired
    public UseCaseAgregarUnLibro(LibroMapper mapperUtils, RepositorioRecurso repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<LibroDto> apply(LibroDto libroDto) {
        return repositorio.save(mapperUtils.mapperToDato(libroDto.getId()).apply(libroDto)).map(mapperUtils.mapDatoToDTO());
    }
}
