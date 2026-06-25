package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FaseDiurnaTest {

    @Test
    public void test01LosCandidatosSonJugadoresVivos() {
        // Arrange
        Jugador jugador1 = new Jugador(new Mafioso());
        jugador1.eliminar();
        FaseDiurna fase = new FaseDiurna();

        // Act y Assert
        assertThrows(IllegalArgumentException.class, ()  -> {
            fase.nominar(jugador1);
        });
    }

    @Test
    public void test02SoloSePuedenVotarALosCandidatos() {
        // Arrange
        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Ciudadano());

        FaseDiurna fase = new FaseDiurna();

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

        FaseDiurna fase = new FaseDiurna();

        // Act
        fase.nominar(jugadorAeliminar);
        fase.nominar(jugador2);

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

        FaseDiurna fase = new FaseDiurna();

        // Act
        fase.nominar(jugador1);
        fase.nominar(jugador2);

        fase.votar(jugador1, jugador2);
        fase.votar(jugador2, jugador1);
        Jugador eliminado = fase.eliminarAlMasVotado();

        // Assert
        assertEquals(JugadorNulo.INSTANCIA,eliminado);
    }
}