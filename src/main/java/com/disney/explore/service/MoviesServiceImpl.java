package com.disney.explore.service;

import com.disney.explore.domain.Genero;
import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.dto.MovieDTO;
import com.disney.explore.repository.GeneroRepo;
import com.disney.explore.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MoviesServiceImpl implements MoviesService {

    private final MovieRepo movieRepo;
    private final GeneroRepo generoRepo;

    @Override
    public List<MovieDTO> getMovieDTO() {
        return movieRepo.findAllDTO();
    }

    @Override
    public void save(Pelicula_Serie pelicula) {
        movieRepo.save(pelicula);
    }

    @Override
    public void update(Pelicula_Serie pelicula) {
        movieRepo.update(pelicula);
    }

    @Override
    public void delete(Long id) {
        movieRepo.delete(id);
    }

    @Override
    public Pelicula_Serie getByName(String name) {
        return movieRepo.getByTitulo(name);
    }

    @Override
    public List<Pelicula_Serie> getByGenre(Long id) {
        return movieRepo.getByIdGenero(id);
    }

    @Override
    public void addGenreToMovie(String titulo, String nombreGenero) {
        Pelicula_Serie p = movieRepo.getByTitulo(titulo);
        Genero g = generoRepo.findByNombre(nombreGenero);
        p.getGeneros().add(g);
    }
}