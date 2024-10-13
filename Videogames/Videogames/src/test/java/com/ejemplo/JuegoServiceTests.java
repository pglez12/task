package com.ejemplo;


import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ejemplo.model.Juego;
import com.ejemplo.repository.JuegoDao;
import com.ejemplo.service.JuegoServiceImp;


/**
 * Unit test class for the JuegoService class.
 * 
 * @author Grupo1
 * @version 1.0
 * @date 09-10-2024
 */
public class JuegoServiceTests {

    @Mock
    private JuegoDao juegoDao;

    @InjectMocks
    private JuegoServiceImp juegoService;

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
        openMocks(this);
    }

    /**
     * Test to verify that getJuegos returns a list of games.
     */
    @Test
    public void testGetJuegosReturnsList() {
        Juego juego1 = new Juego();
        Juego juego2 = new Juego();
        when(juegoDao.findAll()).thenReturn(Arrays.asList(juego1, juego2));
        
        List<Juego> result = juegoService.getJuegos();
        
        if (result.size() == 2) {
            System.out.println(BOLD + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
        } else {
            System.out.println(BOLD + "Test" + testCounter + ": " + RED + "KO" + RESET);
        }
        testCounter++;
    }

    /**
     * Test to verify that getJuegos returns an empty list when an exception occurs.
     */
    @Test
    public void testGetJuegosReturnsEmptyListOnException() {
        when(juegoDao.findAll()).thenThrow(new RuntimeException("Database error"));
        
        List<Juego> result = juegoService.getJuegos();
        
        if (result.isEmpty()) {
            System.out.println(BOLD + "Test" + testCounter + ": " + GREEN + "OK" + RESET);
        } else {
            System.out.println(BOLD + "Test" + testCounter + ": " + RED + "KO" + RESET);
        }
        testCounter++;
    }
    
    
    /**
     * Test to mock and verify the behavior of service eliminarJuego()
     * @author Celia
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
