package com.ejemplo.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		 
		// Retrieve and display the list of juegos; log information on the results.

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
		
		
		 // Load the editable form for the specified juego, or redirect if not found.
		
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

		// Save the juego and redirect to the juegos list.
		
		@PostMapping("/save")
		public String saveJuego(@ModelAttribute Juego juego) {
		    service.save(juego);
		    return "redirect:/juegos"; 
		}
		
		
		
		/**
		 * Deletes game from database
		 * @param id
		 * @return
		 */
		@GetMapping("/delete")
		public String eliminarJuego(@RequestParam("id") int id, Model m) {
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
		 * @return
		 */
		@GetMapping("juegos/new")
		public String cargarForm(Juego juego, Model model) {
			model.addAttribute("juego", juego);
			return "form";
		}
		
		@GetMapping("/siglo20")
		public String mostrarJuegosDelSiglo20(Model model) {
		    List<Juego> juegosDelSiglo20 = service.getJuegosDelSiglo20();
		    model.addAttribute("juegoList", juegosDelSiglo20);
		    return "list"; 
		}
		
	    /**
	     * Handles GET requests to the URL "/juegos/nintendo". Retrieves the list of video games
	     * published by Nintendo from the service layer and adds it to the model for
	     * access in the view.
	     *
	     * @param model The model used to pass data to the view.
	     * @return The name of the view to be loaded, which is "list".
	     */    
	    @GetMapping("/juegos/nintendo")
	    public String listByNintendo(Model model) {
	        log.info("Entro en listByNintendo: Inicializo lista");
	        
	        List<Juego> nintendoList = service.getByPublisher("Nintendo");
	        if (nintendoList != null && !nintendoList.isEmpty()) {
	            model.addAttribute("juegoList", nintendoList);
	            log.info("Se encontraron {} videojuegos", nintendoList.size());
	        } else {
	            log.warn("No se encontraron videojuegos");
	        }
	        
	        return "list";
	    }
	    
	    /**
	     * Handles GET requests to the URL "/juegos/year". Retrieves the list of video games
	     * published in that year from the service layer and adds it to the model for
	     * access in the view.
	     *
	     * @param model The model used to pass data to the view.
	     * @return The name of the view to be loaded, which is "list".
	     */    
	    @GetMapping("/juegos/year")
	    public String showByYear(@RequestParam("year") int year, Model model) {
	        log.info("Entrando en showByYear: Inicializo lista");

	        Calendar calendar = Calendar.getInstance();
	        int currentYear = calendar.get(Calendar.YEAR);

	 
	        if (year < 0 || year > currentYear) {
	            log.warn("El año {} no es válido", year);
	            return "redirect:/juegos"; 
	        }

	        
	        List<Juego> juegosList = service.getByYear(year);
	        if (juegosList != null && !juegosList.isEmpty()) {
	            model.addAttribute("juegoList", juegosList);
	            log.info("Se encontraron {} videojuegos para el año {}", juegosList.size(), year);
	        } else {
	            log.warn("No se encontraron videojuegos para el año {}", year);
	            model.addAttribute("mensaje", "No se encontraron videojuegos para el año " + year);
	        }

	        return "list"; 
	    }
	    
	    /**
	     * Handles GET requests to the URL "/juegos/genre". Retrieves the list of video games
	     * published in that genre from the service layer and adds it to the model for
	     * access in the view.
	     *
	     * @param model The model used to pass data to the view.
	     * @return The name of the view to be loaded, which is "list".
	     */    
	    
	    @GetMapping("/juegos/genre")
	    public String showByGenre(@RequestParam("genre") String genre, Model model) {
	        log.info("Entrando en showByGenre: Inicializo lista");

	        List<Juego> juegosList = service.getByGenre(genre);
	        
	        if (juegosList != null && !juegosList.isEmpty()) {
	            model.addAttribute("juegoList", juegosList);
	            log.info("Se encontraron {} videojuegos del género {}", juegosList.size(), genre);
	        } else {
	            log.warn("No se encontraron videojuegos del género {}", genre);
	            model.addAttribute("mensaje", "No se encontraron videojuegos del género " + genre);
	        }

	        return "list"; 
	    }




		
		
	}


