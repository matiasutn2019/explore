package com.disney.explore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "personajes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Pelicula_Serie> peliculas_series = new ArrayList<>();

    public Personaje(String image, String nombre, Integer edad, Double peso, String historia, Collection<Pelicula_Serie> peliculas_series) {
        this.image = image;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas_series = peliculas_series;
    }

    public Personaje(Long id, String image, String nombre, Integer edad, Double peso, String historia) {
        this.id = id;
        this.image = image;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }
}
