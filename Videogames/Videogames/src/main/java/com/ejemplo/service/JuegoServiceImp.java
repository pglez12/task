package com.ejemplo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.model.Juego;
import com.ejemplo.repository.JuegoDao;

@Service
public class JuegoServiceImp implements JuegoService {

	@Autowired
	JuegoDao juegoDao;

	private static final Logger log = LogManager.getLogger(JuegoService.class);

	@Override
	public List<Juego> getJuegos() {
		List<Juego> juegos = juegoDao.findAll();
		return juegos;
	}

	@Override
	public Optional<Juego> findById(int id) {
		return juegoDao.findById(id);
	}

	@Override
	public void save(Juego juego) {
		juegoDao.save(juego);
	}

	/**
	 * Deletes user from the database
	 * @params int id_juego
	 * @return boolean
	 * @author Celia
	 */
	@Override
	public boolean eliminarJuego(int id_juego) {
		juegoDao.deleteById(id_juego);
		log.warn("La eliminación del juego por parte del Servicio fue posible.");
		return true;
	}
}