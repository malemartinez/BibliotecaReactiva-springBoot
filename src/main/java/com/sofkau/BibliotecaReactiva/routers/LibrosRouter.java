package com.sofkau.BibliotecaReactiva.routers;

import com.sofkau.BibliotecaReactiva.dto.LibroDto;
import com.sofkau.BibliotecaReactiva.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class LibrosRouter {

    @Bean
    public RouterFunction<ServerResponse> modificarUnRecurso(UseCaseModificarLibros useCaseModificarLibros) {
        return route(PUT("/biblioteca/modificarRecurso").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(LibroDto.class)
                        .flatMap(recursoDTO -> useCaseModificarLibros.apply(recursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }

}