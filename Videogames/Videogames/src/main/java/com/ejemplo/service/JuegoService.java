package com.ejemplo.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo.model.Juego;



public interface JuegoService {

	public List<Juego> getJuegos();

	public Optional<Juego> findById(int id);
	
	public void save(Juego juego);
	
	public boolean eliminarJuego(int id_juego);
	
}

