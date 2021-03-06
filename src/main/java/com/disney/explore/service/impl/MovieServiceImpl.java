package com.disney.explore.service.impl;

import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.domain.entity.Character;
import com.disney.explore.domain.entity.Movie;
import com.disney.explore.domain.request.MovieRequest;
import com.disney.explore.domain.response.MovieResponseDetail;
import com.disney.explore.domain.response.MovieResponseDetailList;
import com.disney.explore.domain.response.MovieResponseList;
import com.disney.explore.repository.IMovieRepo;
import com.disney.explore.service.ICharacterService;
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
    private ICharacterService characterService;

    @Override
    @Transactional
    public MovieResponseList findAll() {
        List<Movie> movies = movieRepo.findAll();
        validate(movies);
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
        validate(movieOptional);
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
        Optional<Movie> movie = movieRepo.findByName(name);
        validate(movie);
        return convertUtils.toMovieResponseDetail(movie.get());
    }

    @Override
    @Transactional
    public MovieResponseDetailList findByGenre(long id) {
        List<Movie> movies = movieRepo.findByGenre(id);
        validate(movies);
        return convertUtils.toMovieResponseDetailList(movies);
    }
    
    private Movie buildMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setImage(movieRequest.getImage());
        movie.setTitulo(movieRequest.getTitulo());
        movie.setFechaCreacion(movieRequest.getFechaCreacion());
        movie.setCalificacion(movieRequest.getCalificacion());
        List<Character> characters = new ArrayList<>();
        movieRequest.getPersonajesId().forEach(id -> characters.add(characterService.byId(id)));
        movie.setCharacters(characters);
        return movie;
    }

    private Movie updateMovie(Movie movie, MovieRequest movieRequest) {
        movie.setImage(movieRequest.getImage());
        movie.setTitulo(movieRequest.getTitulo());
        movie.setFechaCreacion(movieRequest.getFechaCreacion());
        movie.setCalificacion(movieRequest.getCalificacion());
        List<Character> characters = new ArrayList<>();
        movieRequest.getPersonajesId().forEach(id -> characters.add(characterService.byId(id)));
        movie.setCharacters(characters);
        return movie;
    }

    private void validate(Optional<Movie> movie) {
        if(movie.isEmpty()) {
            throw new EntityNotFoundException("The movie you are looking for is not registered");
        }
    }

    private void validate(List<Movie> movies) {
        if(movies.isEmpty()) {
            throw new EntityNotFoundException("The movie you are looking for is not registered");
        }
    }
}