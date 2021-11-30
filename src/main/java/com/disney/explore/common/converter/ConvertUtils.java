package com.disney.explore.common.converter;

import com.disney.explore.domain.entity.Character;
import com.disney.explore.domain.entity.Movie;
import com.disney.explore.domain.entity.User;
import com.disney.explore.domain.response.CharacterResponseDetail;
import com.disney.explore.domain.response.CharacterResponseDetailList;
import com.disney.explore.domain.response.CharacterResponseList;
import com.disney.explore.domain.response.CharacterResponse;
import com.disney.explore.domain.response.MovieResponseDetail;
import com.disney.explore.domain.response.MovieResponseDetailList;
import com.disney.explore.domain.response.MovieResponseList;
import com.disney.explore.domain.response.MovieResponse;
import com.disney.explore.domain.response.UserAuthenticatedResponse;
import com.disney.explore.domain.response.UserCreatedResponse;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("convertUtils")
public class ConvertUtils {

    public UserAuthenticatedResponse toUserAuthenticatedResponse(String email, String token) {
        UserAuthenticatedResponse userAuthenticatedResponse = new UserAuthenticatedResponse();
        userAuthenticatedResponse.setEmail(email);
        userAuthenticatedResponse.setToken(token);
        return userAuthenticatedResponse;
    }

    public UserCreatedResponse toUserCreatedResponse(User user) {
        UserCreatedResponse userCreatedResponse = new UserCreatedResponse();
        userCreatedResponse.setId(user.getId());
        userCreatedResponse.setEmail(user.getEmail());
        return userCreatedResponse;
    }


    private CharacterResponse toCharacterResponse(Character character) {
        CharacterResponse characterResponse = new CharacterResponse();
        characterResponse.setNombre(character.getNombre());
        characterResponse.setImage(character.getImage());
        return characterResponse;
    }

    public CharacterResponseList toCharacterResponseList(List<Character> characters) {
        CharacterResponseList characterResponseList = new CharacterResponseList();
        characters.forEach(character -> characterResponseList.getCharacterResponseList().add(toCharacterResponse(character)));
        return characterResponseList;
    }

    public CharacterResponseDetail toCharacterResponseDetail(Character character) {
        CharacterResponseDetail characterResponseDetail = new CharacterResponseDetail();
        characterResponseDetail.setId(character.getId());
        characterResponseDetail.setNombre(character.getNombre());
        characterResponseDetail.setImage(character.getImage());
        characterResponseDetail.setEdad(character.getEdad());
        characterResponseDetail.setPeso(character.getPeso());
        characterResponseDetail.setHistoria(character.getHistoria());
        characterResponseDetail.setPeliculas(character.getPeliculas());
        return characterResponseDetail;
    }

    public CharacterResponseDetailList toCharacterResponseDetailList(List<Character> characters) {
        CharacterResponseDetailList characterResponseDetailList = new CharacterResponseDetailList();
        characters.forEach(character -> characterResponseDetailList.getCharacterResponseDetailList().add(toCharacterResponseDetail(character)));
        return characterResponseDetailList;
    }


    private MovieResponse toMovieResponse(Movie movie) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setImage(movie.getImage());
        movieResponse.setTitulo(movie.getTitulo());
        movieResponse.setFechaCreacion(movie.getFechaCreacion());
        return movieResponse;
    }

    public MovieResponseList toMovieResponseList(List<Movie> movies) {
        MovieResponseList movieResponseList = new MovieResponseList();
        movies.forEach(movie -> movieResponseList.getMovieResponseList().add(toMovieResponse(movie)));
        return movieResponseList;
    }

    public MovieResponseDetail toMovieResponseDetail(Movie movie) {
        MovieResponseDetail movieResponseDetail = new MovieResponseDetail();
        movieResponseDetail.setId(movie.getId());
        movieResponseDetail.setTitulo(movie.getTitulo());
        movieResponseDetail.setImage(movie.getImage());
        movieResponseDetail.setFechaCreacion(movie.getFechaCreacion());
        movieResponseDetail.setPersonajes(movie.getPersonajes());
        return movieResponseDetail;
    }

    public MovieResponseDetailList toMovieResponseDetailList(List<Movie> movies) {
        MovieResponseDetailList movieResponseDetailList = new MovieResponseDetailList();
        movies.forEach(movie -> movieResponseDetailList.getMovieResponseDetailList().add(toMovieResponseDetail(movie)));
        return movieResponseDetailList;
    }

}
