package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturna2Test {
    @Test
    public void elDetectiveRecibeResultadoCorrectoAlInvestigarMafioso() {

        Jugador mafioso = new Jugador(new Mafioso());
        Jugador detective = new Jugador(new Detective());
        ResultadoNocturno resultado = new ResultadoNocturno();

        detective.elegir(mafioso);
        detective.actuarDeNoche(resultado);

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

    @Test
    void jugadorMuertoNoActuaDeNoche() {
        Jugador jugador = new Jugador(new Ciudadano());
        jugador.eliminar();

        assertThrows(IllegalStateException.class,
                () -> jugador.actuarDeNoche(new ResultadoNocturno()));
    }

    @Test
    void noSePuedeElegirJugadorNulo() {
        Jugador mafioso = new Jugador(new Mafioso());
        assertThrows(IllegalArgumentException.class,
                () -> mafioso.elegir(JugadorNulo.INSTANCIA));
    }

    @Test
    void mafiosoMuertoNoPuedeElegir() {
        Jugador mafioso = new Jugador(new Mafioso());
        mafioso.eliminar();

        Jugador objetivo = new Jugador(new Ciudadano());
        assertThrows(IllegalStateException.class,
                () -> mafioso.elegir(objetivo));
    }

    @Test
    void medicoPuedeProtegerseASiMismo() {
        Jugador medico = new Jugador(new Medico());
        assertDoesNotThrow(() -> medico.elegir(medico));
    }

    @Test
    void faseFallaSiIncluyeJugadorMuerto() {

        Jugador vivo = new Jugador(new Ciudadano());
        Jugador muerto = new Jugador(new Ciudadano());
        muerto.eliminar();

        Jugadores jugadores = new Jugadores(List.of(vivo, muerto));

        FaseNocturna fase = new FaseNocturna();

        assertThrows(IllegalStateException.class,
                () -> fase.ejecutar(jugadores));
    }

    @Test
    public void laMafiaNoEliminaAlMedicoSiSeProtegeASiMismo() {

        Jugador medico = new Jugador(new Medico());
        Jugador mafioso = new Jugador(new Mafioso());

        mafioso.elegir(medico);
        medico.elegir(medico);
        Jugadores jugadores = new Jugadores(List.of(mafioso, medico));

        FaseNocturna fase = new FaseNocturna();

        fase.ejecutar(jugadores);

        assertTrue(medico.estaVivo());
    }
}
