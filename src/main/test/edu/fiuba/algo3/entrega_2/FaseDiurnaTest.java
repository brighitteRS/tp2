package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.FaseDiurna;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Urna.Urna;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class FaseDiurnaTest {

    @Test
    public void test01SeEliminaAlJugadorMasVotado() {

        // Arrange
        Jugador jugadorAeliminar = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Ciudadano());
        Jugador jugador3 = new Jugador(new Ciudadano());
        Jugador jugador4 = new Jugador(new Ciudadano());
        Jugador jugador5 = new Jugador(new Ciudadano());

        List<Jugador> candidatos = new ArrayList<>();
        candidatos.add(jugadorAeliminar);
        candidatos.add(jugador2);
        Urna urna = new Urna(candidatos);
        FaseDiurna fase = new FaseDiurna(urna);

        // Act
        jugadorAeliminar.votar(urna, jugador2);
        jugador2.votar(urna, jugadorAeliminar);
        jugador3.votar(urna, jugador2);
        jugador4.votar(urna, jugadorAeliminar);
        jugador5.votar(urna, jugadorAeliminar);


        Jugador eliminado = fase.eliminarAlMasVotado();

        // Assert
        assertEquals(jugadorAeliminar, eliminado);

    }

    @Test
    public void test02SiEmpatanEnLaVotacionSeCancelaLaEliminacion() {
        // Arrange
        Jugador jugador1 = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Ciudadano());

        List<Jugador> candidatos = new ArrayList<>();
        candidatos.add(jugador1);
        candidatos.add(jugador2);
        Urna urna = new Urna(candidatos);
        FaseDiurna fase = new FaseDiurna(urna);

        // Act
        jugador1.votar(urna, jugador2);
        jugador2.votar(urna, jugador1);
        Jugador eliminado = fase.eliminarAlMasVotado();

        // Assert
        assertNull(eliminado);

    }

}
