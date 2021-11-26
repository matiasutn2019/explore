package com.disney.explore.domain.request;

import com.disney.explore.domain.entity.Genre;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

  private String image;
  private String titulo;
  private Date fechaCreacion;
  private Integer calificacion;
  private List<Genre> generos;

}
