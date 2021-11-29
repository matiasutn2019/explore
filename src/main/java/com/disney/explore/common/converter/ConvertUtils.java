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
    return null;
  }

  public CharacterResponseList toCharacterResponseList(List<Character> characters) {
    return null;
  }

  public CharacterResponseDetail toCharacterResponseDetail(Character characters) {
    return null;
  }

  public CharacterResponseDetailList toCharacterResponseDetailList(List<Character> characters) {
    return null;
  }

  private MovieResponse toMovieResponse(Movie movie) {
    return null;
  }

  public MovieResponseList toMovieResponseList(List<Movie> movies) {
    return null;
  }

  public MovieResponseDetail toMovieResponseDetail(Movie movie) {
    return null;
  }

  public MovieResponseDetailList toMovieResponseDetailList(List<Movie> movie) {
    return null;
  }

}
