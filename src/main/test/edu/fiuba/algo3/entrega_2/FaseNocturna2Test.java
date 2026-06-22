package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturna2Test {
    @Test
    public void elDetectiveRecibeResultadoCorrectoAlInvestigarMafioso() {

        Jugador mafioso = new Jugador(new Mafioso());
        Jugador detective = new Jugador(new Detective()); //tiene q ser um jugador
        ResultadoNocturno resultado = new ResultadoNocturno();

        detective.elegir(mafioso);
        detective.actuarDeNoche(resultado);
        // no debe ser bando un string (no usar dato primitivo)
        assertEquals(BandoMafia.INSTANCIA,detective.resultadoInvestigacion());
    }

    @Test
    public void elDetectiveRecibeResultadoCorrectoAlInvestigarCiudadano() {

        Jugador ciudadano = new Jugador(new Ciudadano());
        Jugador detective = new Jugador(new Detective());
        ResultadoNocturno resultado = new ResultadoNocturno();

        detective.elegir(ciudadano);
        detective.actuarDeNoche(resultado);
        assertEquals(BandoCiudadano.INSTANCIA,detective.resultadoInvestigacion());
    }

    @Test
    public void elDetectiveRecibeAlPadrinoComoCiudadano() {

        Jugador padrino = new Jugador(new Padrino());
        Jugador detective = new Jugador(new Detective());
        ResultadoNocturno resultado = new ResultadoNocturno();

        detective.elegir(padrino);
        detective.actuarDeNoche(resultado);
        assertEquals(BandoCiudadano.INSTANCIA,detective.resultadoInvestigacion());
    }

    @Test
    public void elDetectiveNoPuedeInvestigarAlMismoJugadorDosVecesConsecutivas() {

        Jugador objetivo = new Jugador(new Ciudadano());

        Detective detective = new Detective();

        assertDoesNotThrow(() -> detective.elegir(objetivo));

        assertThrows(IllegalArgumentException.class, () -> detective.elegir(objetivo));
    }

    @Test
    public void elMedicoNoPuedeProtegerAlMismoJugadorDosNochesConsecutivas() {

        Jugador objetivo = new Jugador(new Ciudadano());

        Medico medico = new Medico();

        assertDoesNotThrow(() -> medico.elegir(objetivo));

        assertThrows(IllegalArgumentException.class, () -> medico.elegir(objetivo));
    }
    //codigo repetido en elegir (medico y detective) hacer refactor
}
