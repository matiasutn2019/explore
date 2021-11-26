package com.disney.explore.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private String image;
    private String titulo;
    private Date fecha_creacion;
}
