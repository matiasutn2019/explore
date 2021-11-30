package com.disney.explore.domain.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDetail {
    private Long id;
    private String image;
    private String titulo;
    private String fechaCreacion;
    private Integer calificacion;
    private List<Character> characters;

}
