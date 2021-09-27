package com.disney.explore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Image image;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Pelicula_Serie> listPersonajePeli = new ArrayList<>();

}
