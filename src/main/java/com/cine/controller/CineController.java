package com.cine.controller;

import com.cine.entity.Movie;
import com.cine.service.CineService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CineController {

    private final CineService cineService;

    public CineController(CineService cineService) {
        this.cineService = cineService;
    }

    @GetMapping("/peliculas")
    public List<Movie> obtenerPeliculas() {
        return cineService.obtenerPeliculas();
    }

    @DeleteMapping("/EliminarPelicula/{id}")
    public ResponseEntity<String> eliminar(@PathVariable UUID id) {
        cineService.eliminar(id);
        return ResponseEntity.ok("Película eliminada");
    }

    @PutMapping("/ActualizarPelicula/{id}")
    public ResponseEntity<Movie> actualizar(@PathVariable UUID id, @RequestBody Movie movie) {
        Movie updatedMovie = cineService.actualizar(id, movie);
        return ResponseEntity.ok(updatedMovie);
    }
}