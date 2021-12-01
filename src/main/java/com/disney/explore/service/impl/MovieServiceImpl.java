package com.disney.explore.service.impl;

import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.domain.entity.Character;
import com.disney.explore.domain.entity.Movie;
import com.disney.explore.domain.request.MovieRequest;
import com.disney.explore.domain.response.MovieResponseDetail;
import com.disney.explore.domain.response.MovieResponseDetailList;
import com.disney.explore.domain.response.MovieResponseList;
import com.disney.explore.repository.ICharacterRepo;
import com.disney.explore.repository.IMovieRepo;
import com.disney.explore.service.IMovieService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovieRepo movieRepo;

    @Autowired
    private ConvertUtils convertUtils;

    @Autowired
    private ICharacterRepo characterRepo;

    @Override
    @Transactional
    public MovieResponseList findAll() {
        List<Movie> movies = movieRepo.findAll();
        return convertUtils.toMovieResponseList(movies);
    }

    @Override
    @Transactional
    public MovieResponseDetail create(MovieRequest movieRequest) {
        Movie movie = buildMovie(movieRequest);
        movieRepo.save(movie);
        return convertUtils.toMovieResponseDetail(movie);
    }

    @Override
    @Transactional
    public MovieResponseDetail update(long id, MovieRequest movieRequest) {
        Optional<Movie> movieOptional = movieRepo.findById(id);
        if (movieOptional.isEmpty()) {
            throw new EntityNotFoundException("Movie not found");
        }
        Movie movie = updateMovie(movieOptional.get(), movieRequest);
        movieRepo.save(movie);
        return convertUtils.toMovieResponseDetail(movie);
    }

    @Override
    @Transactional
    public void delete(long id) {
        movieRepo.deleteById(id);
    }

    @Override
    @Transactional
    public MovieResponseDetail findByName(String name) {
        Movie movie = movieRepo.findByName(name);
        return convertUtils.toMovieResponseDetail(movie);
    }

    @Override
    @Transactional
    public MovieResponseDetailList findByGenre(long id) {
        List<Movie> movies = movieRepo.findByGenre(id);
        return convertUtils.toMovieResponseDetailList(movies);
    }
    
    private Movie buildMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setImage(movieRequest.getImage());
        movie.setTitulo(movieRequest.getTitulo());
        movie.setFechaCreacion(movieRequest.getFechaCreacion());
        movie.setCalificacion(movieRequest.getCalificacion());
        List<Character> characters = new ArrayList<>();
        movieRequest.getPersonajesId().forEach(id -> characters.add(characterRepo.getById(id)));
        return movie;
    }

    private Movie updateMovie(Movie movie, MovieRequest movieRequest) {
        movie.setImage(movieRequest.getImage());
        movie.setTitulo(movieRequest.getTitulo());
        movie.setFechaCreacion(movieRequest.getFechaCreacion());
        movie.setCalificacion(movieRequest.getCalificacion());
        List<Character> characters = new ArrayList<>();
        movieRequest.getPersonajesId().forEach(id -> characters.add(characterRepo.getById(id)));
        return movie;
    }
}