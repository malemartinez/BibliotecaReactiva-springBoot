package com.sofkau.BibliotecaReactiva.routers;

import com.sofkau.BibliotecaReactiva.dto.LibroDto;
import com.sofkau.BibliotecaReactiva.usecase.UseCaseModificarLibros;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ModificarUnLibroRouter {
    @Bean
    public RouterFunction<ServerResponse> modificarUnLibro(UseCaseModificarLibros useCaseModificarLibros) {
        return route(PUT("/biblioteca/modificarLibro").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(LibroDto.class)
                        .flatMap(recursoDTO -> useCaseModificarLibros.apply(recursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
