package com.cine.service.imp;

import com.cine.entity.Movie;
import com.cine.service.CineService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
public class CineServiceImpl implements CineService {

    private final WebClient webClient;

    public CineServiceImpl(
            @Value("${supabase.url}") String url,
            @Value("${supabase.key}") String key
    ) {
        this.webClient = WebClient.builder()
                .baseUrl(url + "/rest/v1")
                .defaultHeader("apikey", key)
                .defaultHeader("Authorization", "Bearer " + key)
                .build();
    }

    @Override
    public List<Movie> obtenerPeliculas() {
        return webClient.get()
                .uri("/movies")
                .retrieve()
                .bodyToFlux(Movie.class)
                .collectList()
                .block();
    }

    @Override
    public void eliminar(UUID id) {
        webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .path("/movies")
                        .queryParam("id", "eq." + id.toString())
                        .build())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Override
    public Movie actualizar(UUID id, Movie movie) {
        List<Movie> response = webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .path("/movies")
                        .queryParam("id", "eq." + id.toString())
                        .build())
                .header("Prefer", "return=representation") // 🔥 CLAVE
                .bodyValue(movie)
                .retrieve()
                .bodyToFlux(Movie.class)
                .collectList()
                .block();

        return (response != null && !response.isEmpty()) ? response.get(0) : null;
    }
}