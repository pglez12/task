package com.ejemplo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
//PARA DELETE test
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.ejemplo.controller.JuegoController;
import com.ejemplo.model.Juego;
import com.ejemplo.service.JuegoService;

//para eliminar controller test ()

/**
 * Unit test class for the JuegoController class.
 * 
 * @author Grupo1
 * @version 1.0
 * @date 09-10-2024
 */
public class JuegoControllerTests {

	@Mock
	private JuegoService juegoService;

	@InjectMocks // para crear una instancia de la clase y automáticamente inyectar los mocks
					// creados con @Mock en sus dependencias
	private JuegoController juegoController;

	private MockMvc mockMvc; // para simular llamadas get/post

	private static final Logger log = LogManager.getLogger(JuegoController.class);
	private Model model;

	private static int testCounter = 1;

	// ANSI escape codes for formatting
	private static final String RESET = "\u001B[0m";
	private static final String BOLD = "\u001B[1m";
	private static final String GREEN = "\u001B[32m";
	private static final String RED = "\u001B[31m";

	/**
	 * Initializes mocks before each test.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		model = mock(Model.class);
		mockMvc = MockMvcBuilders.standaloneSetup(JuegoControllerTests.class).build();

	}

	/**
	 * Test to verify the behavior of the listJuegos method when video games are
	 * available.
	 */
	@Test
	public void testListJuegosWithGames() {
		List<Juego> juegos = Arrays.asList(new Juego(), new Juego());
		when(juegoService.getJuegos()).thenReturn(juegos);

		String viewName = juegoController.listJuegos(model);

		verify(model).addAttribute("juegoList", juegos);
		if (viewName.equals("list")) {
			System.out.println(BOLD + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
		} else {
			System.out.println(BOLD + "Test" + testCounter + ": " + RED + "KO" + RESET);
		}
		testCounter++;
	}

	/**
	 * Test to verify the behavior of the listJuegos method when video games aren't
	 * available.
	 */
	@Test
	public void testListJuegosWithoutGames() {
		when(juegoService.getJuegos()).thenReturn(Arrays.asList());

		String viewName = juegoController.listJuegos(model);

		verify(model, never()).addAttribute(anyString(), any());
		if (viewName.equals("list")) {
			System.out.println(BOLD + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
		} else {
			System.out.println(BOLD + "Test" + testCounter + ": " + RED + "KO" + RESET);
		}
		testCounter++;
	}

	/**
	 * Configures the mock behaviour, simulates an http post connection and tests if
	 * the endpoint that the deletion Controller returns is the same as the one
	 * given here.
	 * @author Celia
	 * @throws Exception because of mockmvc
	 */
	@Test
	public void eliminarJuegoTest() throws Exception {
		int fakeGameId = 5;
		String route = juegoController.eliminarJuego(fakeGameId);
		if (route.contains("redirect:/juegos")) {
			System.out.println(BOLD + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
		} else {
			System.out.println(BOLD + "Test" + testCounter + ": " + RED + "KO" + RESET);
		}


	}

}
