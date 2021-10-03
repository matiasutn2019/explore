package com.disney.explore.service;

import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.PersonajeDTO;
import com.disney.explore.repository.CharactersRepo;
import com.disney.explore.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CharactersServiceImpl implements CharactersService {

    private final CharactersRepo charactersRepo;
    private final MovieRepo movieRepo;

    @Override
    public List<PersonajeDTO> getCharDTO() {
        return charactersRepo.findAllDTO();
    }

    @Override
    public void save(Personaje personaje) {
        charactersRepo.save(personaje);
    }

    @Override
    public void delete(Long id) {
        charactersRepo.delete(id);
    }

    @Override
    public void update(Personaje personaje) {
        charactersRepo.update(personaje);
    }

    @Override
    public Personaje getByName(String nombre) {
        Personaje p = charactersRepo.getByName(nombre);
        return p;
    }

    @Override
    public List<Personaje> getByAge(Integer edad) {
        List<Personaje> p = charactersRepo.getByAge(edad);
        return p;
    }

    @Override
    public List<Personaje> getByMovie(Long id) {
        List<Personaje> p = charactersRepo.getByMovie(id);
        return p;
    }

    @Override
    public void addCharacterToMovie(String nombre, String titulo) {
        Personaje p = charactersRepo.getByName(nombre);
        Pelicula_Serie peli = movieRepo.getByTitulo(titulo);
        p.getPeliculas_series().add(peli);
    }
}