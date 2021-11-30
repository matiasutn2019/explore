package com.disney.explore.domain.entity;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "CHARACTERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "CHARACTER_ID")
    private Long id;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "EDAD")
    private Integer edad;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "HISTORIA")
    private String historia;

    @JoinColumn(name = "MOVIES_ID")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Movie> peliculas;

}
