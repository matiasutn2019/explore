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
import java.util.ArrayList;
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
        List<CharacterResponse> characterResponses = new ArrayList<>();
        characters.forEach(character -> characterResponses.add(toCharacterResponse(character)));
        return new CharacterResponseList(characterResponses);
    }

    public CharacterResponseDetail toCharacterResponseDetail(Character character) {
        CharacterResponseDetail characterResponseDetail = new CharacterResponseDetail();
        List<String> nombrePeliculas = new ArrayList<>();
        characterResponseDetail.setId(character.getId());
        characterResponseDetail.setNombre(character.getNombre());
        characterResponseDetail.setImage(character.getImage());
        characterResponseDetail.setEdad(character.getEdad());
        characterResponseDetail.setPeso(character.getPeso());
        characterResponseDetail.setHistoria(character.getHistoria());
        character.getMovies().forEach(movie -> nombrePeliculas.add(movie.getTitulo()));
        characterResponseDetail.setNombrePeliculas(nombrePeliculas);
        return characterResponseDetail;
    }

    public CharacterResponseDetailList toCharacterResponseDetailList(List<Character> characters) {
        List<CharacterResponseDetail> characterResponseDetails = new ArrayList<>();
        characters.forEach(character -> characterResponseDetails.add(toCharacterResponseDetail(character)));
        return new CharacterResponseDetailList(characterResponseDetails);
    }


    private MovieResponse toMovieResponse(Movie movie) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setImage(movie.getImage());
        movieResponse.setTitulo(movie.getTitulo());
        movieResponse.setFechaCreacion(movie.getFechaCreacion());
        return movieResponse;
    }

    public MovieResponseList toMovieResponseList(List<Movie> movies) {
        List<MovieResponse> movieResponses = new ArrayList<>();
        movies.forEach(movie -> movieResponses.add(toMovieResponse(movie)));
        return new MovieResponseList(movieResponses);
    }

    public MovieResponseDetail toMovieResponseDetail(Movie movie) {
        MovieResponseDetail movieResponseDetail = new MovieResponseDetail();
        List<String> nombrePersonajes = new ArrayList<>();
        movieResponseDetail.setId(movie.getId());
        movieResponseDetail.setTitulo(movie.getTitulo());
        movieResponseDetail.setImage(movie.getImage());
        movieResponseDetail.setFechaCreacion(movie.getFechaCreacion());
        movieResponseDetail.setCalificacion(movie.getCalificacion());
        movie.getCharacters().forEach(character -> nombrePersonajes.add(character.getNombre()));
        movieResponseDetail.setNombrePersonajes(nombrePersonajes);
        return movieResponseDetail;
    }

    public MovieResponseDetailList toMovieResponseDetailList(List<Movie> movies) {
        List<MovieResponseDetail> movieResponseDetails = new ArrayList<>();
        movies.forEach(movie -> movieResponseDetails.add(toMovieResponseDetail(movie)));
        return new MovieResponseDetailList(movieResponseDetails);
    }

}
