package com.disney.explore.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "MOVIE_ID")
    private Long id;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "FECHA_CREACION")
    private String fechaCreacion;

    @Column(name = "CALIFICACION")
    private Integer calificacion;

    @JoinColumn(name = "CHARACTERS_ID")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Character> personajes;

}
