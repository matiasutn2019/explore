package com.disney.explore.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterResponse {

    private Long id;
    private String image;
    private String nombre;
}
