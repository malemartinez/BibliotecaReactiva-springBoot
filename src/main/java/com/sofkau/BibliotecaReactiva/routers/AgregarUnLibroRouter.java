package com.sofkau.BibliotecaReactiva.routers;

import com.sofkau.BibliotecaReactiva.dto.LibroDto;
import com.sofkau.BibliotecaReactiva.usecase.UseCaseAgregarUnLibro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AgregarUnLibroRouter {
    @Bean
    public RouterFunction<ServerResponse> agregarUnRecurso(UseCaseAgregarUnLibro useCaseAgregarUnLibro) {
        return route(POST("/biblioteca/agregarLibrito").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(LibroDto.class)
                        .flatMap(recursoDTO -> useCaseAgregarUnLibro.apply(recursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
