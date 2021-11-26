package com.disney.explore.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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
    private Date fechaCreacion;

    @Column(name = "CALIFICACION")
    private Integer calificacion;

    @JoinColumn(name = "GENRE_ID")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Genre> generos;

}
