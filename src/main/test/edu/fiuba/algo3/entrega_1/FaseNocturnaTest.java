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

        Mafioso mafioso1 = new Mafioso();

        mafioso1.elegirVictima(victima);

        assertEquals(victima, mafioso1.obtenerVictima());
    }

    @Test
    public void laMafiaRechazaVictimasInvalidas() {

        Jugador jugador = new Jugador(new Ciudadano());
        jugador.cambiarEstado(new Muerto());

        Jugador mafioso = new Jugador(new Mafioso());

        Mafioso mafioso1 = new Mafioso();
        Mafioso mafioso2 = new Mafioso();

        assertThrows(IllegalArgumentException.class, () -> {mafioso1.elegirVictima(jugador);});

        assertThrows(IllegalArgumentException.class, () -> {mafioso2.elegirVictima(mafioso);});
    }

    @Test
    public void elMedicoSalvaAlJugadorAtacadoPorLaMafia() {

        Jugador victima = new Jugador(new Ciudadano());
        Mafia mafia = new Mafia();

        Mafioso mafioso = new Mafioso();

        mafioso.elegirVictima(victima);

        mafia.recolectarVotos(List.of(mafioso));

        Medico medico = new Medico();
        medico.elegirProtegido(victima);

        Jugador jugadorMedico = new Jugador(medico);

        FaseNocturna fase = new FaseNocturna(mafia, List.of(jugadorMedico));

        fase.ejecutar();

        assertTrue(victima.estaVivo());
    }

    @Test
    public void laMafiaEliminaAlJugadorNoProtegido() {

        Jugador victima = new Jugador(new Ciudadano());
        Jugador protegido = new Jugador(new Ciudadano());

        Mafia mafia = new Mafia();

        Mafioso mafioso = new Mafioso();
        mafioso.elegirVictima(victima);

        mafia.recolectarVotos(List.of(mafioso));

        Medico medico = new Medico();
        medico.elegirProtegido(protegido);

        Jugador jugadorMedico = new Jugador(medico);

        FaseNocturna fase = new FaseNocturna(mafia, List.of(jugadorMedico));

        fase.ejecutar();

        assertFalse(victima.estaVivo());
        assertTrue(protegido.estaVivo());
    }
}
