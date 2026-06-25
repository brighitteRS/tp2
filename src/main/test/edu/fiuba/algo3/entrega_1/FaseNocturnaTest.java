package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.FaseNocturna.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Roles.*;
import edu.fiuba.algo3.modelo.Ronda;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturnaTest {

    @Test
    public void laMafiaSeleccionaUnaVictimaValidaDuranteLaNoche() {

        Jugador victima = new Jugador(new Ciudadano());
        ResultadoNocturno resultado = new ResultadoNocturno();

        Jugador mafioso1 = new Jugador(new Mafioso());
        Mafia mafia = new Mafia(List.of(mafioso1));
        mafioso1.elegir(victima);

        mafia.actuarDeNoche(resultado);

        assertEquals(victima, mafia.obtenerResolucion());
    }

    @Test
    public void laMafiaRechazaVictimasInvalidas() {

        Jugador jugador = new Jugador(new Ciudadano());
        jugador.eliminar();

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

        Jugadores jugadores = new Jugadores(List.of(jugadorMafioso, jugadorMedico));

        FaseNocturna fase = new FaseNocturna();

        fase.ejecutar(jugadores,new Ronda(1));

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

        Jugadores jugadores = new Jugadores(List.of(mafioso, jugadorMedico));

        FaseNocturna fase = new FaseNocturna();

        fase.ejecutar(jugadores, new Ronda(1));

        assertFalse(victima.estaVivo());
        assertTrue(protegido.estaVivo());
    }

    @Test
    public void elPadrinoDesempataLaVotacionDeLaMafia() {

        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Ciudadano());

        Jugador mafioso = new Jugador(new Mafioso());
        Jugador padrino = new Jugador(new Padrino());

        mafioso.elegir(jugador1);
        padrino.elegir(jugador2);

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(List.of(mafioso, padrino));

        mafia.actuarDeNoche(resultado);

        assertEquals(jugador2, mafia.obtenerResolucion());
    }

    @Test
    public void siTodosLosMafiososVotanDistintoDecideElPadrino() {

        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Ciudadano());
        Jugador maria = new Jugador(new Ciudadano());

        Jugador mafioso1 = new Jugador(new Mafioso());
        Jugador mafioso2 = new Jugador(new Mafioso());
        Jugador padrino = new Jugador(new Padrino());

        mafioso1.elegir(jugador1);
        mafioso2.elegir(jugador2);
        padrino.elegir(maria);

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(List.of(mafioso1, mafioso2, padrino));

        mafia.actuarDeNoche(resultado);

        assertEquals(maria, mafia.obtenerResolucion());
    }

    @Test
    public void elVotoDelPadrinoNoModificaUnaVotacionConMayoria() {

        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Ciudadano());

        Jugador mafioso1 = new Jugador(new Mafioso());
        Jugador mafioso2 = new Jugador(new Mafioso());
        Jugador padrino = new Jugador(new Padrino());

        mafioso1.elegir(jugador1);
        mafioso2.elegir(jugador1);
        padrino.elegir(jugador2);

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(List.of(mafioso1, mafioso2, padrino));

        mafia.actuarDeNoche(resultado);

        assertEquals(jugador1, mafia.obtenerResolucion());
    }
}
