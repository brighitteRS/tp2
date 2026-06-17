package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mazo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        // Arrange
        List<Rol> cartas = new ArrayList<>();
        cartas.add(new Mafioso());
        cartas.add(new Detective());
        cartas.add(new Ciudadano());
        cartas.add(new Ciudadano());
        cartas.add(new Ciudadano());
        cartas.add(new Ciudadano());

        List<Rol> copia = new ArrayList<>(cartas);

        // Act
        new Aleatorio().mezclar(copia);

        // Assert
        assertNotEquals(cartas, copia);
    }

    @Test
    public void test02CadaJugadorRecibeUnRol() {

        // Arrange
        Mazo mazo = Mazo.crear(6, new Aleatorio());
        List<Jugador> jugadores = crearJugadores(6);

        // Act
        mazo.repartir(jugadores);

        // Assert
        for (Jugador jugador : jugadores) {
            assertTrue(jugador.tieneRolAsignado());
        }
    }

//Este test debemos revisarlo
    @Test
    public void test03JugadorSoloPuedeVerSuPropioRol() {

        // Arrange
        Mazo mazo = Mazo.crear(6, new Aleatorio());
        List<Jugador> jugadores = crearJugadores(6);
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

        // Arrange
        Mazo mazo = Mazo.crear(7, new Aleatorio());
        List<Jugador> jugadores = crearJugadores(7);

        // Act
        Partida partida = new Partida(jugadores, mazo);

        List<Jugador> mafiosos = jugadores.stream()
                .filter(Jugador::esDeLaMafia)
                .collect(Collectors.toList());
        Jugador noMafioso = jugadores.stream()
                .filter(j -> !j.esDeLaMafia())
                .findFirst().get();

        // Assert
        assertTrue(mafiosos.get(0).esComplice(mafiosos.get(1)));
        assertFalse(mafiosos.get(0).esComplice(noMafioso));
    }

    private List<Jugador> crearJugadores(int cantidad) {
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            jugadores.add(new Jugador());
        }
        return jugadores;
    }

}





