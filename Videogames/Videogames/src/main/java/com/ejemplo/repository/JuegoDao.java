package com.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.model.Juego;

@Repository
public interface JuegoDao extends JpaRepository<Juego,Integer> {

	
}
