package com.ejemplo;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

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

import java.util.Optional;

/**
 * Unit test class for the TestCargarForm class.
 * 
 * @author Grupo1
 * @version 1.0
 * @date 09-10-2024
 */

public class TestCargarForm {
    
    @Mock
    private JuegoService service; 

    @InjectMocks
    private JuegoController controller; 

    private Model model; 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
        model = new BindingAwareModelMap(); 
    }

    // Test to ensure that the form is loaded with a juego when it exists.
    
    @Test
    void testCargarEditableForm_JuegoExists() {
    	
        int juegoId = 1;
        Juego juego = new Juego(); 
        when(service.findById(juegoId)).thenReturn(Optional.of(juego));
        
        String result = controller.cargarEditableForm(juegoId, model);

        assertThat(result).isEqualTo("form");
        assertThat(model.getAttribute("juego")).isEqualTo(juego);
    }
    
    // Test to verify redirection when a juego is not found by its ID.

    @Test
    void testCargarEditableForm_JuegoNotFound() {
    	
        int juegoId = 1;
        when(service.findById(juegoId)).thenReturn(Optional.empty());

        String result = controller.cargarEditableForm(juegoId, model);

        assertThat(result).isEqualTo("redirect:/juegos");
    }
    
    // Test to check that the model remains empty when no juego is found.

    @Test
    void testCargarEditableForm_ModelIsEmptyWhenJuegoNotFound() {
    	
        int juegoId = 1;
        when(service.findById(juegoId)).thenReturn(Optional.empty());

        String result = controller.cargarEditableForm(juegoId, model);

        assertThat(result).isEqualTo("redirect:/juegos");
        assertThat(model.getAttribute("juego")).isNull(); 
    }
    
    // Test to ensure that saving a juego redirects to the juegos list.

    @Test
    void testSaveJuego() {
        // Arrange
        Juego juego = new Juego(); 

        // Act
        String result = controller.saveJuego(juego);

        verify(service).save(juego); 
        assertThat(result).isEqualTo("redirect:/juegos"); 
    }
}
