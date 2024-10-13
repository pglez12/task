package com.ejemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ejemplo.model.Juego;


@Repository
public interface JuegoDao extends JpaRepository<Juego,Integer>{
	
	// Custom queries for retrieving juegos based on specific criteria.
	
	
	//Siglo 20
	
	@Query("SELECT j FROM Juego j WHERE j.year BETWEEN 1901 AND 2000")
	
    List<Juego> findAllSiglo20();
	
	//Editor

	List<Juego> findByPublisher(String publisher);
	
	//Año
	
	List<Juego> findByYear (int year);
	
	//Género
	
	List<Juego> findByGenre(String genre);

}
