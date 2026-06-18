package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mazo.*;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Roles.Detective;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Roles.Medico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

        // Act
        List<Jugador> jugadores = mazo.repartir(6);

        // Assert
        assertEquals(6, jugadores.size());
    }

    @Test
    public void test03JugadorSoloPuedeVerSuPropioRol() {

        // Arrange
        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Ciudadano());

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
        Jugador jugador1 = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Mafioso());
        Jugador jugador3 = new Jugador(new Ciudadano());

        // Act
        Bando bandoComplice = jugador1.consultarBando(jugador2);
        Bando bandoCiudadano = jugador1.consultarBando(jugador3);

        // Assert
        assertNotNull(bandoComplice);
        assertNull(bandoCiudadano);
    }
}





