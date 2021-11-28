package com.disney.explore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ExploreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExploreApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	@Bean
	CommandLineRunner run(UserService userService, CharactersService charactersService, MoviesService moviesService, GeneroRepo generoRepo) {
		return args -> {
			userService.saveRole(new Role("ROLE_USER"));
			userService.saveRole(new Role("ROLE_ADMIN"));

			userService.registrarUser(new User("juan", "123", "matiasunr@yahoo.com.ar", new ArrayList<>()));
			userService.addRoleToUser("juan", "ROLE_USER");

			userService.registrarUser(new User("maria", "777", "mcevini@frro.utn.edu.ar", new ArrayList<>()));
			userService.addRoleToUser("maria", "ROLE_ADMIN");

			Movie p1 = new Movie("imagen juan", "el juan y el pato", new Date(10/10/10), 5, new ArrayList<>());
			Movie p2 = new Movie("imagen juan", "el juan y el raton", new Date(10/10/10), 4, new ArrayList<>());
			Movie p3 = new Movie("imagen juan", "el juan y el perro", new Date(10/10/10), 3, new ArrayList<>());
			Movie p4 = new Movie("imagen miguel", "el miguel y el raton", new Date(10/10/10), 2, new ArrayList<>());
			Movie p5 = new Movie("imagen jose", "el jose y el pato y el perro", new Date(10/10/10), 1, new ArrayList<>());

			Character pj1 = new Character("imagen pato", "pato donald", 99, 15.0, "personaje pato creado hace muchos años", new ArrayList<>());
			Character pj2 = new Character("imagen raton", "raton mickey", 88, 5.0, "personaje raton creado hace muchos años", new ArrayList<>());
			Character pj3 = new Character("imagen perro", "perro pluto", 77, 30.0, "personaje perro creado hace muchos años", new ArrayList<>());

			Genero g1 = new Genero("terror", "imagen terror");
			Genero g2 = new Genero("comedia", "imagen comedia");
			Genero g3 = new Genero("drama", "imagen drama");
			Genero g4 = new Genero("acción", "imagen Acción");
			Genero g5 = new Genero("ciencia ficción", "imagen ciencia ficción");

			pj1.getPeliculas_series().add(p1);
			pj1.getPeliculas_series().add(p5);
			pj2.getPeliculas_series().add(p2);
			pj2.getPeliculas_series().add(p4);
			pj3.getPeliculas_series().add(p3);
			pj3.getPeliculas_series().add(p5);

			p1.getGeneros().add(g1);
			p1.getGeneros().add(g2);
			p1.getGeneros().add(g3);
			p2.getGeneros().add(g1);
			p2.getGeneros().add(g4);
			p3.getGeneros().add(g5);
			p4.getGeneros().add(g5);
			p4.getGeneros().add(g3);
			p5.getGeneros().add(g4);
			p5.getGeneros().add(g3);

			charactersService.save(pj1);
			charactersService.save(pj2);
			charactersService.save(pj3);

			moviesService.save(p1);
			moviesService.save(p2);
			moviesService.save(p3);
			moviesService.save(p4);
			moviesService.save(p5);

			generoRepo.save(g1);
			generoRepo.save(g2);
			generoRepo.save(g3);
			generoRepo.save(g4);
			generoRepo.save(g5);

		};
	}

 */
}
