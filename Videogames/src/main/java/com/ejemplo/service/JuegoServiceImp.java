package com.ejemplo.service;

import java.util.ArrayList;
import java.util.Collections;
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
    private JuegoDao juegoDao;

    private static final Logger log = LogManager.getLogger(JuegoServiceImp.class);

    @Override
    public List<Juego> getJuegos() {
        try {
            return juegoDao.findAll();
        } catch (Exception e) {
            return new ArrayList<>(); 
        }
    }


    @Override
    public Optional<Juego> findById(int id) {
        return juegoDao.findById(id);
    }

    @Override
    public void save(Juego juego) {
        juegoDao.save(juego);    
    }
    
	@Override
	public boolean eliminarJuego(int id_juego) {
		juegoDao.deleteById(id_juego);
		log.warn("La eliminación del juego por parte del Servicio fue posible.");
		return true;
	}

    @Override
    public List<Juego> getJuegosDelSiglo20() {
        return juegoDao.findAllSiglo20();
    }

    @Override
    public List<Juego> getByPublisher(String publisher) {
        log.info("Entro en getByPublisher: Inicializo lista");
        
        try {
            List<Juego> juegos = juegoDao.findByPublisher(publisher);
            return juegos != null ? juegos : Collections.emptyList();
        } catch (Exception e) {
            log.warn("No se encontraron videojuegos");
            return Collections.emptyList();
        }
    }
    
	@Override
	public List<Juego> getByYear(int year) {
		log.info("Entro en getByYear: Inicializo lista");
		
		try {
			List<Juego> juegos = juegoDao.findByYear(year);
			return juegos != null ? juegos : Collections.emptyList();
		} catch (Exception e) {
			log.warn("No se encontraron videojuegos");
			return Collections.emptyList();
		}
	}
	
	@Override
    public List<Juego> getByGenre(String genre) {
        return juegoDao.findByGenre(genre);
    }
}
