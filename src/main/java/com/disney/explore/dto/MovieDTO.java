package com.disney.explore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private String image;
    private String titulo;
    private Date fecha_creacion;
}
