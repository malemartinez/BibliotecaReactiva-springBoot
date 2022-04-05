package com.sofkau.BibliotecaReactiva.routers;

import com.sofkau.BibliotecaReactiva.usecase.UseCaseBorrarUnLibro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BorrarLibro {
    @Bean
    public RouterFunction<ServerResponse> borrarUnRecurso(UseCaseBorrarUnLibro useCaseBorrarUnLibro) {
        return route(
                DELETE("/biblioteca/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseBorrarUnLibro.get(request.pathVariable("id")), Void.class))
                        .onErrorResume((Error) -> ServerResponse.notFound().build())
        );
    }
}
