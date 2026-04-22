package com.cine.service;

import java.util.List;
import java.util.UUID;
import com.cine.entity.Movie;

public interface CineService {

    List<Movie> obtenerPeliculas();

    void eliminar(UUID id);

    Movie actualizar(UUID id, Movie movie);
}