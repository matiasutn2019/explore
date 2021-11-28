package com.disney.explore.service;

import com.disney.explore.domain.request.MovieRequest;
import com.disney.explore.domain.response.MovieResponseDetail;
import com.disney.explore.domain.response.MovieResponseDetailList;
import com.disney.explore.domain.response.MovieResponseList;

public interface IMovieService {

  MovieResponseList findAll();

  MovieResponseDetail create(MovieRequest movieRequest);

  MovieResponseDetail update(long id, MovieRequest movieRequest);

  void delete(long id);

  MovieResponseDetail findByName(String name);

  MovieResponseDetailList findByGenre(long id);

}
