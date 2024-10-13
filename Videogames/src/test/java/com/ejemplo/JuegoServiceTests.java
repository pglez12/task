package com.ejemplo;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

import com.ejemplo.controller.JuegoController;
import com.ejemplo.model.Juego;
import com.ejemplo.repository.JuegoDao;
import com.ejemplo.service.JuegoService;
import com.ejemplo.service.JuegoServiceImp;

public class JuegoServiceTests {

    @Mock
    private JuegoDao juegoDao;
    
    @Mock // Asegúrate de que esto es un mock
    private JuegoService service;

    @InjectMocks
    private JuegoServiceImp juegoService;

    @InjectMocks // Inject mocks into the controller as well
    private JuegoController juegoController;

    private Model model;

    private static int testCounter = 1;

    // ANSI escape codes for formatting
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

    private Juego createJuego(Long id, String name, String publisher) {
        Juego juego = new Juego();
        juego.setId(id);
        juego.setName(name);
        juego.setPublisher(publisher);
        return juego;
    }

    @BeforeEach
    public void setup() {
        openMocks(this);
        model = mock(Model.class);
    }
    
    /**
     *  Test to verify 
     * that getJuegos returns a list*/

    @Test
    public void testGetJuegosReturnsList() {
        System.out.println(BOLD + BLUE + "Test" + testCounter + ": " + YELLOW + "Test getJuegos() return" + RESET);
        Juego juego1 = createJuego(1L, "Juego1", "Nintendo");
        Juego juego2 = createJuego(2L, "Juego2", "Nintendo");
        when(juegoDao.findAll()).thenReturn(Arrays.asList(juego1, juego2));

        List<Juego> result = juegoService.getJuegos();

        if (result.size() == 2) {
            System.out.println(BOLD + YELLOW + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
        } else {
            System.out.println(BOLD + YELLOW + "Test" + testCounter + ": " + RED + "KO" + RESET);
        }
        testCounter++;
    }
    
    /**
     *  Test to verify 
     * that getJuegos returns an Exception with an empty list*/

    @Test
    public void testGetJuegosReturnsEmptyListOnException() {
        System.out.println(BOLD + BLUE + "Test" + testCounter + ": " + YELLOW + "Test getJuegos() return when exception occurs" + RESET);
        when(juegoDao.findAll()).thenThrow(new RuntimeException("Database error"));

        List<Juego> result = juegoService.getJuegos();

        if (result.isEmpty()) {
            System.out.println(BOLD + YELLOW + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
        } else {
            System.out.println(BOLD + YELLOW + "Test" + testCounter + ": " + RED + "KO" + RESET);
        }
        testCounter++;
    }
    
    /**
     * Test case to verify that the listJuegos method correctly retrieves
     * a list of games and adds it to the model when there are available games.
     */


    @Test
    public void testListNintendoWithGames() {

        Juego juego1 = createJuego(1L, "Juego1", "Nintendo");
        Juego juego2 = createJuego(2L, "Juego2", "Nintendo");
        List<Juego> juegos = Arrays.asList(juego1, juego2);

        when(service.getJuegos()).thenReturn(juegos);

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
     * Test case to verify that the listJuegos method returns the correct view
     * when there are no games available in the list.
     */


    @Test
    public void testListNintendoWithoutGames() {
        when(juegoService.getJuegos()).thenReturn(Arrays.asList());
        
        String viewName = juegoController.listJuegos(model); 
        
        if (viewName.equals("list")) {
            System.out.println(BOLD + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
        } else {
            System.out.println(BOLD + "Test" + testCounter + ": " + RED + "KO" + RESET);
        }
        testCounter++;
    }
    
    /**
     * Test to mock and verify the behavior of service eliminarJuego()
     */
    
    @Test
    public void testEliminarJuego() {
        int fakeGameId = 5;
        doNothing().when(juegoDao).deleteById(fakeGameId);
        boolean result = juegoService.eliminarJuego(fakeGameId);
        verify(juegoDao, times(1)).deleteById(fakeGameId);
        
        if (result) {
            System.out.println(BOLD + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
        } else {
            System.out.println(BOLD + "Test" + testCounter + ": " + RED + "KO" + RESET);
        }
        testCounter++;
    } 
}



