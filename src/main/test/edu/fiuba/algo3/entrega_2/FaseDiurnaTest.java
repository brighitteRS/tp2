package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Urna.SistemaNominaciones;
import edu.fiuba.algo3.modelo.Urna.Urna;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class FaseDiurnaTest {

    @Test
    public void test01LosCandidatosSonJugadoresVivos() {
        // Arrange
        Jugador jugador1 = new Jugador(new Mafioso());
        jugador1.eliminar();
        SistemaNominaciones nominaciones = new SistemaNominaciones();
        FaseDiurna fase = new FaseDiurna(nominaciones);

        // Act

        // Assert
        assertThrows(IllegalArgumentException.class, ()  -> {
            fase.nominar(jugador1);
        });
    }

    @Test
    public void test02SoloSePuedenVotarALosCandidatos() {
        // Arrange
        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Ciudadano());
        SistemaNominaciones nominaciones = new SistemaNominaciones();
        Urna urna = new Urna();

        FaseDiurna fase = new FaseDiurna(urna, nominaciones);

        // Act y Assert
        assertThrows(IllegalArgumentException.class, () -> {
            fase.votar(jugador1, jugador2);
        });

    }

    @Test
    public void test03SeEliminaAlJugadorMasVotado() {

        // Arrange
        Jugador jugadorAeliminar = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Ciudadano());
        Jugador jugador3 = new Jugador(new Ciudadano());

        SistemaNominaciones nominaciones = new SistemaNominaciones(Arrays.asList(jugadorAeliminar, jugador2));
        Urna urna = new Urna();

        FaseDiurna fase = new FaseDiurna(urna, nominaciones);

        // Act
        fase.votar(jugadorAeliminar, jugador2);
        fase.votar(jugador2, jugadorAeliminar);
        fase.votar(jugador3, jugadorAeliminar);

        Jugador eliminado = fase.eliminarAlMasVotado();

        // Assert
        assertEquals(jugadorAeliminar, eliminado);


    }

    @Test
    public void test04SiEmpatanEnLaVotacionSeCancelaLaEliminacion() {

        // Arrange
        Jugador jugador1 = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Ciudadano());

        SistemaNominaciones nominaciones = new SistemaNominaciones(Arrays.asList(jugador1, jugador2));
        Urna urna = new Urna();
        FaseDiurna fase = new FaseDiurna(urna, nominaciones);

        // Act
        fase.votar(jugador1, jugador2);
        fase.votar(jugador2, jugador1);
        Jugador eliminado = fase.eliminarAlMasVotado();

        // Assert
        assertEquals(JugadorNulo.INSTANCIA, eliminado);

    }

}