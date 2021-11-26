package com.disney.explore.service;

import com.disney.explore.domain.entity.Movie;
import com.disney.explore.domain.response.MovieResponse;
import com.disney.explore.repository.GeneroRepo;
import com.disney.explore.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private GeneroRepo generoRepo;

    @Override
    public List<MovieResponse> getMovieDTO() {
        return movieRepo.findAllDTO();
    }

    @Override
    public void save(Movie pelicula) {
        movieRepo.save(pelicula);
    }

    @Override
    public void update(Movie pelicula) {
        movieRepo.update(pelicula);
    }

    @Override
    public void delete(Long id) {
        movieRepo.delete(id);
    }

    @Override
    public Movie getByName(String name) {
        return movieRepo.getByTitulo(name);
    }

    @Override
    public List<Movie> getByGenre(Long id) {
        return movieRepo.getByIdGenero(id);
    }

}