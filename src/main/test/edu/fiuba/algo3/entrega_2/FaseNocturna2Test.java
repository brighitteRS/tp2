package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturna2Test {
    @Test
    public void elDetectiveRecibeResultadoCorrectoAlInvestigarMafioso() {

        Jugador mafioso = new Jugador(new Mafioso());
        Detective detective = new Detective();

        detective.elegirInvestigado(mafioso);
        detective.actuarDeNoche();
        assertEquals("Mafia", detective.resultadoInvestigacion());
    }

    @Test
    public void elDetectiveRecibeResultadoCorrectoAlInvestigarCiudadano() {

        Jugador ciudadano = new Jugador(new Ciudadano());
        Detective detective = new Detective();
        detective.elegirInvestigado(ciudadano);
        detective.actuarDeNoche();
        assertEquals("Ciudadano", detective.resultadoInvestigacion());
    }

    @Test
    public void elDetectiveRecibeAlPadrinoComoCiudadano() {

        Jugador padrino = new Jugador(new Padrino());
        Detective detective = new Detective();
        detective.elegirInvestigado(padrino);
        detective.actuarDeNoche();
        assertEquals("Ciudadano", detective.resultadoInvestigacion());
    }

    @Test
    public void elDetectiveNoPuedeInvestigarAlMismoJugadorDosVecesConsecutivas() {

        Jugador objetivo = new Jugador(new Ciudadano());

        Detective detective = new Detective();

        assertDoesNotThrow(() -> detective.elegirInvestigado(objetivo));

        assertThrows(IllegalArgumentException.class, () -> detective.elegirInvestigado(objetivo));
    }

    @Test
    public void elMedicoNoPuedeProtegerAlMismoJugadorDosNochesConsecutivas() {

        Jugador objetivo = new Jugador(new Ciudadano());

        Medico medico = new Medico();

        assertDoesNotThrow(() -> medico.elegirProtegido(objetivo));

        assertThrows(IllegalArgumentException.class, () -> medico.elegirProtegido(objetivo));
    }
}
