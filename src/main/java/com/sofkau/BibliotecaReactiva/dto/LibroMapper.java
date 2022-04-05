package com.sofkau.BibliotecaReactiva.dto;

import com.sofkau.BibliotecaReactiva.collections.libros;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Component
public class LibroMapper {

    public libros fromDTO(LibroDto dto) {
        libros libros = new libros();
        libros.setId(dto.getId());
        libros.setTitulo(dto.getTitulo());
        libros.setGenero(dto.getClasificacion());
        libros.setArea(dto.getArea());
        libros.setPrestado(dto.isPrestado());
        libros.setFechaPrestamo(dto.getFechaPrestamo());
        return libros;
    }

    public LibroDto fromCollection(libros collection) {
        LibroDto libroDto = new LibroDto();
        libroDto.setId(collection.getId());
        libroDto.setTitulo(collection.getTitulo());
        libroDto.setClasificacion(collection.getGenero());
        libroDto.setArea(collection.getArea());
        libroDto.setPrestado(collection.isPrestado());
        libroDto.setFechaPrestamo(collection.getFechaPrestamo());
        return libroDto;
    }

    public List<LibroDto> fromCollectionList(List<libros> collection) {
        if (collection == null) {
            return null;
        }
        List<LibroDto> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            libros libros = (libros) listTracks.next();
            list.add(fromCollection(libros));
        }

        return list;
    }

    public Function<LibroDto, libros> mapperToDato(String id) {
        return updateDato -> {
            var recurso = new libros();
            recurso.setId(id);
            recurso.setTitulo(updateDato.getTitulo());
            recurso.setGenero(updateDato.getClasificacion());
            recurso.setArea(updateDato.getArea());
            recurso.setPrestado(updateDato.isPrestado());
            recurso.setFechaPrestamo(updateDato.getFechaPrestamo());
            return recurso;
        };
    }

    public Function<libros, LibroDto> mapDatoToDTO() {
        return entity -> new LibroDto(entity.getId(), entity.getTitulo(), entity.getGenero(), entity.getArea(), entity.isPrestado());
    }
}
