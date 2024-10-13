package com.ejemplo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.model.Juego;
import com.ejemplo.service.JuegoService;

/**
 * Requests Handler
 * 
 * @author Grupo1
 * @version 1.4
 * @date 09-10-2024
 */

	
	@Controller
	public class JuegoController {
		
		@Autowired
		JuegoService service;
		
		 private static final Logger log = LogManager.getLogger(JuegoController.class);

		@GetMapping("/juegos")
		public String listJuegos(Model model) {
			log.info("Entro en listJuegos: Inicializo lista");
		    List<Juego> juegoList = service.getJuegos();
		    if (juegoList != null && !juegoList.isEmpty()) {
	            model.addAttribute("juegoList", juegoList);
	            log.info("Se encontraron {} videojuegos", juegoList.size());
	        } else {
	            log.warn("No se encontraron videojuegos");
	        }
		    return "list"; 
		}
		
		/**
		 * Shows the view of the pre-loaded form when clicking "Edit" button on the view
		 * @param id
		 * @author Paula
		 * @return valid id? returns form
		 * 			invalid id? redirects to list page
		 */
		@GetMapping("/edit")
		public String cargarEditableForm(@RequestParam("id") int id, Model m) {
		    Optional<Juego> juegoOptional = service.findById(id);
		    if (juegoOptional.isPresent()) {
		        m.addAttribute("juego", juegoOptional.get());
		        return "form";
		    } else {
		        return "redirect:/juegos"; 
		    }
		}

		/**
		 * Allows to create or update an entity
		 * @param id for update
		 * @author Paula
		 * @return redirects to list page
		 */
		@PostMapping("/save")
		public String saveJuego(@ModelAttribute Juego juego) {
		    service.save(juego);
		    return "redirect:/juegos"; 
		}
		
		/**
		 * Deletes game from database
		 * @param id
		 * @author Celia
		 * @return
		 */
		@PostMapping("/delete/{id}")
		public String eliminarJuego(@PathVariable("id") int id) {
		    log.info("Accediendo a la eliminación por parte del Controlador");
		    Optional<Juego> juego = service.findById(id);
		    if (id > 0 && juego.isPresent()) {
		        log.info("Controlador eliminó juego correctamente.");
		        service.eliminarJuego(id);
		        return "redirect:/juegos";
		    } else {
		        log.warn("Controlador no consiguió eliminar el juego correctamente.");
		        return "redirect:/juegos";
		    }
		}
		
		/**
		 * Shows the view of the empty form when clicking "new Game" button on the view
		 * @param id
		 * @author Guillermina
		 * @return
		 */
		@GetMapping("juegos/new")
		public String cargarForm(Juego juego, Model model) {
			model.addAttribute("juego", juego);
			return "form";
		}
		
	}


