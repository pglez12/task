package com.ejemplo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import com.ejemplo.controller.JuegoController;
import com.ejemplo.model.Juego;
import com.ejemplo.service.JuegoService;

import static org.mockito.Mockito.when;

/**
 * Unit test class for the FiltroSiglo20.
 * 
 * @author Grupo1
 * @version 1.0
 * @date 09-10-2024
 */

public class TestFiltroSiglo {
    
    @Mock
    private JuegoService service; 

    @InjectMocks
    private JuegoController controller; 

    private Model model; 

    private int testCounter = 1; // Definir testCounter aquí

    // ANSI escape codes for formatting
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
        model = new BindingAwareModelMap(); 
    }
    
    /**
     * Test to verify the behavior of the filtroSiglo20 method.
     */
    
    @Test
    public void testGetJuegosDelSiglo20() {
        Juego juego1 = new Juego();
        juego1.setYear(1995); 
        Juego juego2 = new Juego();
        juego2.setYear(2000);
        
        
        when(service.getJuegosDelSiglo20()).thenReturn(Arrays.asList(juego1, juego2));
        
        controller.mostrarJuegosDelSiglo20(model);
        
        List<Juego> result = (List<Juego>) model.getAttribute("juegoList");
        
        if (result.size() == 2) {
            System.out.println(BOLD + "Test " + testCounter + ": " + GREEN + "OK" + RESET);
        } else {
            System.out.println(BOLD + "Test " + testCounter + ": " + RED + "KO" + RESET);
        }
        testCounter++;
    }
}

