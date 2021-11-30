package com.disney.explore.domain.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("Movie")
public class MovieResponse {

    private String image;
    private String titulo;
    private String fechaCreacion;
}
