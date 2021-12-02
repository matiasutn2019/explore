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
@JsonRootName("Movie")
public class MovieResponseDetail extends MovieResponse {
    private Long id;
    private Integer calificacion;
    private List<String> nombrePersonajes;

}
