package com.disney.explore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "peliculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pelicula_Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String titulo;
    private Date fecha_creacion;
    private Integer calificacion; // la restricción 1-5 conviene hacerla en el html

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "peliculas_series")
    private List<Personaje> personajes = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Genero> generos = new ArrayList<>();

    public Pelicula_Serie(String image, String titulo, Date fecha_creacion, Integer calificacion, List<Personaje> personajes, List<Genero> generos) {
        this.image = image;
        this.titulo = titulo;
        this.fecha_creacion = fecha_creacion;
        this.calificacion = calificacion;
        this.personajes = personajes;
        this.generos = generos;
    }
}
