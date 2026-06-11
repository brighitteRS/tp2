package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mazo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyList;


public class MazoTest {

    @Test
    public void test01MazoConSeisJugadoresTieneComposicionCorrecta() {

        // Arrange
        Mazo mazo = Mazo.crear(6, new Aleatorio());

        // Act
        long mafiosos = mazo.contarRolesDe(Mafioso.class);
        long especiales = mazo.contarRolesDe(Detective.class) + mazo.contarRolesDe(Medico.class);
        long ciudadanos = mazo.contarRolesDe(Ciudadano.class);
        int total = mazo.totalDeCartas();

        // Assert
        assertEquals(1, mafiosos);
        assertEquals(1, especiales);
        assertEquals(4, ciudadanos);
        assertEquals(6, total);
    }

    @Test
    public void test02VerificarQueElRepartoDeCartasSeaAleatorio() {

        Mezclador mezclador = mock(Mezclador.class);

        Mazo mazo = Mazo.crear(6, mezclador);

        List<Jugador> jugadores = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            jugadores.add(new Jugador("Jugador " + i));
        }

        mazo.repartir(jugadores);

        verify(mezclador).mezclar(anyList());
    }

    @Test
    public void test02CadaJugadorRecibeUnRol() {

        Mazo mazo = Mazo.crear(6, new Aleatorio());

        List<Jugador> jugadores = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            jugadores.add(new Jugador("Jugador " + i));
        }

        mazo.repartir(jugadores);

        for (Jugador jugador : jugadores) {
            assertTrue(jugador.tieneRolAsignado());
        }

        long rolesAsignados = jugadores.stream()
                .filter(Jugador::tieneRolAsignado)
                .count();

        assertEquals(6, rolesAsignados);
    }

//Este test debemos revisarlo
    @Test
    public void test03JugadorSoloPuedeVerSuPropioRol() {

        // Arrage
        Mazo mazo = new Mazo(6);
        List<Jugador> jugadores = new ArrayList<>();

        jugadores.add(new Jugador("Jugador " + 1));
        jugadores.add(new Jugador("Jugador " + 2));

        mazo.repartir(jugadores);

        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        // Act
        Bando bandoPropio = jugador1.consultarBando(jugador1);
        Bando bandoAjeno = jugador1.consultarBando(jugador2);

        // Assert
        assertNotNull(bandoPropio);
        assertNull(bandoAjeno);

    }
    
    @Test
    public void test04MafiososSeConocenEntreEllos() {

        // arrgange
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.asignarRol(new Mafioso());
        jugador2.asignarRol(new Mafioso());
        jugador3.asignarRol(new Ciudadano());

        //Act

        Bando bandoComplice = jugador1.consultarBando(jugador2);
        Bando bandoCiudadano = jugador1.consultarBando(jugador3);

        // assert
        assertNotNull(bandoComplice);
        assertNull(bandoCiudadano);
    }
}





