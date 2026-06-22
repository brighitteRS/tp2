package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.FaseNocturna.Mafia;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Roles.Medico;
import edu.fiuba.algo3.modelo.Urna.Urna;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01JugadorEliminadoPuedeRevelarSuRol() {
        // Arrange
        Rol rolCiudadano = new Ciudadano();
        Jugador victima = new Jugador(rolCiudadano);
        Jugador jugador2 = new Jugador(new Ciudadano());

        // Act
        victima.cambiarEstado(new Muerto());

        // Assert
        assertEquals(rolCiudadano, victima.consultarRol(jugador2));
    }

    @Test
    public void test02JugadorEliminadoNoPuedeActuar() {


        // Arrange
        Jugador mafioso = new Jugador(new Mafioso());
        Jugador victima = new Jugador(new Ciudadano());
        mafioso.cambiarEstado(new Muerto());
        // Act
        mafioso.elegir(victima);
        // Assert
        assertTrue(mafioso.obtenerVictima().estaNulo());
    }

}