package com.disney.explore.service;

import com.disney.explore.domain.AppUser;
import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.domain.Personaje;
import com.disney.explore.domain.Role;
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
    public void delete(String nombre) {
        charactersRepo.delete(getByName(nombre));
    }

    @Override
    public void update(Personaje personaje, String nombre) {
        delete(nombre);
        save(personaje);
    }

    @Override
    public Personaje getByName(String nombre) {
        return charactersRepo.getByName(nombre);
    }

    @Override
    public List<Personaje> getByAge(Integer edad) {
        return charactersRepo.getByAge(edad);
    }

    @Override
    public List<Personaje> getByMovie(Long id) {
        return charactersRepo.getByMovie(id);
    }

    @Override
    public void addMovieToCharacter(String nombre, String titulo) {
        Personaje p = charactersRepo.getByName(nombre);
        Pelicula_Serie peli = movieRepo.getByTitulo(titulo);
        if (p != null && peli != null) {
            p.getListPersonajePeli().add(peli);
        } else {
            throw new NullPointerException("EL PERSONAJE Y/O LA PELÍCULA NO ESTÁN REGISTRADOS!!!");
        }
    }
}
