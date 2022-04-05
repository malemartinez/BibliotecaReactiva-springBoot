package com.sofkau.BibliotecaReactiva.routers;

import com.sofkau.BibliotecaReactiva.usecase.UseCaseDisponibilidadLibro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DisponibilidadRouter {
    @Bean
    public RouterFunction<ServerResponse> disponibilidad(UseCaseDisponibilidadLibro useCaseDisponibilidadLibro) {
        return route(GET("/library/recursoDisponible/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseDisponibilidadLibro.apply(request.pathVariable("id")),String.class))
                        .onErrorResume((Error) -> ServerResponse.badRequest().build())
        );
    }
}
