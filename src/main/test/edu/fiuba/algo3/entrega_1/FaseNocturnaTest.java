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

    @Test
    public void elPadrinoDesempataLaVotacionDeLaMafia() {

        Jugador juan = new Jugador(new Ciudadano());
        Jugador pedro = new Jugador(new Ciudadano());

        Jugador mafioso = new Jugador(new Mafioso());
        Jugador padrino = new Jugador(new Padrino());

        mafioso.elegir(juan);
        padrino.elegir(pedro);

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(List.of(mafioso, padrino));

        mafia.actuarDeNoche(resultado);

        assertEquals(pedro, mafia.obtenerResolucion());
    }

    @Test
    public void siTodosLosMafiososVotanDistintoDecideElPadrino() {

        Jugador juan = new Jugador(new Ciudadano());
        Jugador pedro = new Jugador(new Ciudadano());
        Jugador maria = new Jugador(new Ciudadano());

        Jugador mafioso1 = new Jugador(new Mafioso());
        Jugador mafioso2 = new Jugador(new Mafioso());
        Jugador padrino = new Jugador(new Padrino());

        mafioso1.elegir(juan);
        mafioso2.elegir(pedro);
        padrino.elegir(maria);

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(List.of(mafioso1, mafioso2, padrino));

        mafia.actuarDeNoche(resultado);

        assertEquals(maria, mafia.obtenerResolucion());
    }

    @Test
    public void elVotoDelPadrinoNoModificaUnaVotacionConMayoria() {

        Jugador juan = new Jugador(new Ciudadano());
        Jugador pedro = new Jugador(new Ciudadano());

        Jugador mafioso1 = new Jugador(new Mafioso());
        Jugador mafioso2 = new Jugador(new Mafioso());
        Jugador padrino = new Jugador(new Padrino());

        mafioso1.elegir(juan);
        mafioso2.elegir(juan);
        padrino.elegir(pedro);

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(List.of(mafioso1, mafioso2, padrino));

        mafia.actuarDeNoche(resultado);

        assertEquals(juan, mafia.obtenerResolucion());
    }

}
