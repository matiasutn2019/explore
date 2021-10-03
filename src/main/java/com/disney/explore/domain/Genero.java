package com.disney.explore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "generos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String image;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "generos")
    private List<Pelicula_Serie> peliculas_genero = new ArrayList<>();

    public Genero(String nombre, String image, List<Pelicula_Serie> peliculas_genero) {
        this.nombre = nombre;
        this.image = image;
        this.peliculas_genero = peliculas_genero;
    }
}
