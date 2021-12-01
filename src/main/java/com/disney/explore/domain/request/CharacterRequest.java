package com.disney.explore.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRequest {

  private String image;
  private String nombre;
  private Integer edad;
  private Double peso;
  private String historia;

}
