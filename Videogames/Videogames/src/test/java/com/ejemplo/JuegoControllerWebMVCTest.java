package com.ejemplo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplo.controller.JuegoController;
import com.ejemplo.service.JuegoService;

/**
 * Integration tests
 * This class checks the web environment through JuegoController
 * Mocks the controller and service injected in it
 * @author Guillermina
 */
@WebMvcTest(JuegoController.class)
public class JuegoControllerWebMVCTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	JuegoService service;

    /**
	 * Checks that endpoint /juegos/new returns status 200 ok 
	 * Checks that the response view contains a form with method POST
	 */
	@Test
	public void cargarFormTest() throws Exception {
		mockMvc.perform(get("/juegos/new"))
		   .andExpect(status().isOk())
		   .andExpect(content().string(containsString("<form method=\"post\"")));
	}
	
	/**
	 * Checks that endpoint /juegos response status is 200 ok;
	 */
	@Test
	public void listJuegosTest() throws Exception {
		mockMvc.perform(get("/juegos"))
		   .andExpect(status().isOk());
	}
	
}
