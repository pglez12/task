package com.ejemplo.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo.model.Juego;



public interface JuegoService {

	// Retrieves a list of all video games.
	
	public List<Juego> getJuegos();
	
	// Finds a video game by its ID, returning an Optional.

	public Optional<Juego> findById(int id);
	
	// Finds a video game by its ID, returning an Optional.
	
	public void save(Juego juego);
	
	// Saves a new or updated video game.
	
	// Retrieves a list of video games from the 20th century.

	public List<Juego> getJuegosDelSiglo20();

	/**
		 * Retrieves a list of all video games published by Nintendo
		 *  from the data access layer.
		 *
		 * @return A list of Juego objects representing all video games. Returns an
		 *         empty list if no games are found or an error occurs.
		 */
	public List<Juego> getByPublisher(String publisher);
	
	// Deletes a video game by its ID, returning a boolean to indicate success.

	public boolean eliminarJuego(int id_juego);
	
	// Retrieves a list of video games released in a specific year.
	
	public List<Juego>getByYear (int year);
	
	// Retrieves a list of video games of a specific genre.

	public List<Juego> getByGenre(String genre);
	
	
	
	
	
	
	
	
}

