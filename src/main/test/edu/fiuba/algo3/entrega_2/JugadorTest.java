package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.Rol;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01JugadorEliminadoPuedeRevelarSuRol() {
        // Arrange
        Rol rolCiudadano = new Ciudadano();
        Jugador victima = new Jugador(rolCiudadano);

        // Act
        victima.eliminar();

        // Assert
        assertEquals(rolCiudadano, victima.consultarRol(victima));
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

    @Test
    public void elJugadorVivoPuedeVerSiempreSuRol() {

        Jugador jugador = new Jugador(new Ciudadano());

        Rol rol = jugador.consultarRol(jugador);

        assertEquals(Ciudadano.class, rol.getClass());
    }

    @Test
    public void elJugadorNoPuedeVerRolDeOtroJugador() {

        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Mafioso());

        Rol rol = jugador1.consultarRol(jugador2);

        assertEquals(RolNulo.INSTANCIA, rol);
    }

    @Test
    public void jugadorMuertoRevelaSuRolATodos() {

        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Mafioso());

        jugador1.eliminar();

        Rol rol = jugador1.consultarRol(jugador2);
        assertEquals(Ciudadano.class, rol.getClass());
    }
}