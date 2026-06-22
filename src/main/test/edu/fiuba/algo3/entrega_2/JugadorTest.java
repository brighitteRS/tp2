package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01JugadorEliminadoPuedeRevelarSuRol() {
        // Arrange
        Rol rolCiudadano = new Ciudadano();
        Jugador victima = new Jugador(rolCiudadano);
        Jugador jugador2 = new Jugador(new Ciudadano());

        // Act
        victima.eliminar();

        // Assert
        assertEquals(rolCiudadano, victima.consultarRol(jugador2));
    }

    @Test
    public void test02JugadorEliminadoNoPuedeActuar() {


        // Arrange
        Jugador mafioso = new Jugador(new Mafioso());
        Jugador victima = new Jugador(new Ciudadano());
        mafioso.eliminar();

        // Assert
        assertThrows(IllegalStateException.class, () -> {
            mafioso.elegir(victima);
        });
    }
}