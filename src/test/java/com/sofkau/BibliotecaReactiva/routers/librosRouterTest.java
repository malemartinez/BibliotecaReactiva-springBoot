package com.sofkau.BibliotecaReactiva.routers;

import com.sofkau.BibliotecaReactiva.collections.libros;
import com.sofkau.BibliotecaReactiva.dto.LibroDto;
import com.sofkau.BibliotecaReactiva.dto.LibroMapper;
import com.sofkau.BibliotecaReactiva.repositories.RepositorioRecurso;
import com.sofkau.BibliotecaReactiva.usecase.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest
class librosRouterTest {


}