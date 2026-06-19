package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Muerto;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Urna.Urna;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UrnaTest {

    @Test
    public void test01LosCandidatosSonJugadoresVivos() {

        // Arrange
        Jugador jugador1 = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Ciudadano());
        Urna urna = new Urna();

        // Act
        jugador1.cambiarEstado(new Muerto());

        // Assert
        assertThrows(IllegalArgumentException.class, ()  -> {
            jugador2.nominar(urna, jugador1);
        });

        // Separar la responsabilidad de las nominaciones

    }

    @Test
    public void test02SoloSePuedenVotarALosCandidatos() {
        // Arrange
        List<Jugador> candidatos = new ArrayList<>();
        Jugador jugador1 = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Ciudadano());
        candidatos.add(jugador1);
        Urna urna = new Urna(candidatos);

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
           jugador1.votar(urna, jugador2);
        });

    }

}
