package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.FaseNocturna.*;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturnaTest {

    @Test
    public void laMafiaSeleccionaUnaVictimaValidaDuranteLaNoche() {

        Jugador victima = new Jugador(new Ciudadano());

        Jugador mafioso1 = new Jugador(new Mafioso());
        Mafia mafia = new Mafia();
        mafioso1.elegir(victima);

        mafia.actuarDeNoche(List.of(mafioso1));

        assertEquals(victima, mafia.obtenerResolucion());
    }

    @Test
    public void laMafiaRechazaVictimasInvalidas() {

        Jugador jugador = new Jugador(new Ciudadano());
        jugador.cambiarEstado(new Muerto());

        Jugador mafioso = new Jugador(new Mafioso());

        Jugador mafioso1 = new Jugador(new Mafioso());
        Jugador mafioso2 = new Jugador(new Mafioso());

        assertThrows(IllegalArgumentException.class, () -> {mafioso1.elegir(jugador);});

        assertThrows(IllegalArgumentException.class, () -> {mafioso2.elegir(mafioso);});
    }

    @Test
    public void elMedicoSalvaAlJugadorAtacadoPorLaMafia() {

        Jugador victima = new Jugador(new Ciudadano());

        Jugador jugadorMafioso = new Jugador(new Mafioso());

        jugadorMafioso.elegir(victima);

        Jugador jugadorMedico = new Jugador(new Medico());

        jugadorMedico.elegir(victima);

        FaseNocturna fase = new FaseNocturna(List.of(jugadorMafioso,jugadorMedico));

        fase.ejecutar();

        assertTrue(victima.estaVivo());
    }

    @Test
    public void laMafiaEliminaAlJugadorNoProtegido() {

        Jugador victima = new Jugador(new Ciudadano());
        Jugador protegido = new Jugador(new Ciudadano());

        Jugador mafioso = new Jugador(new Mafioso());
        mafioso.elegir(victima);

        Jugador jugadorMedico = new Jugador(new Medico());
        jugadorMedico.elegir(protegido);

        FaseNocturna fase = new FaseNocturna(List.of(mafioso,jugadorMedico));

        fase.ejecutar();

        assertFalse(victima.estaVivo());
        assertTrue(protegido.estaVivo());
    }
}
