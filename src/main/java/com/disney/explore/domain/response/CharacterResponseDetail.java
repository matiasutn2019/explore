package com.disney.explore.domain.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("Character")
public class CharacterResponseDetail extends CharacterResponse {
    private Long id;
    private Integer edad;
    private Double peso;
    private String historia;
    private List<String> nombrePeliculas;

}
