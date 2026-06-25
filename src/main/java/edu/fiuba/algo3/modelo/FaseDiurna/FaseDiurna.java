package edu.fiuba.algo3.modelo.FaseDiurna;


import edu.fiuba.algo3.modelo.Fase;
import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Urna.*;

import java.util.List;

public class FaseDiurna implements Fase {

    private Urna urna;
    private SistemaNominaciones nominaciones;
    private ResultadoDiurno resultado;

    public FaseDiurna() {
        this.urna = new Urna();
        this.nominaciones = new SistemaNominaciones();
    }

    public void iniciarDebate(int tiempo) {
        // Aca se deberia mostrar el tiempo en la interfaz grafica y que se puedan comunicar los vivos
    }

    public void nominar( Jugador jugadorANominar ) {
        jugadorANominar.validarPuedeSerObjetivo();
        nominaciones.agregarCandidato(jugadorANominar);
    }

    public void votar(Jugador votador, Jugador votado) {
        votador.validarSiPuedeActuar();

        if ( !nominaciones.esCandidato(votado) ) {
            throw new IllegalArgumentException("No se pueden votar jugadores que no son candidatos");
        }
        urna.registrarVoto( votador, votado );
    }

    public Jugador eliminarAlMasVotado(){
        List<Jugador> ganadores = urna.getGanadores();

        if ( ganadores.size() > 1  ) {
            return JugadorNulo.INSTANCIA;
        }

        Jugador eliminado = ganadores.get(0);
        eliminado.eliminar();
        return eliminado;
    }

    public List<Jugador> obtenerNominados() {
        return nominaciones.obtenerCandidatos();
    }



    @Override
    public void ejecutar(Jugadores jugadores){
        iniciarDebate(120);

        List<Jugador> listaJugadores = jugadores.vivos();

        for (Jugador j: listaJugadores) {
            Jugador nominado = j.seleccionar(listaJugadores);
            this.nominar(nominado);
        }

        List<Jugador> nominados = nominaciones.obtenerCandidatos();

        for (Jugador j : listaJugadores) {
            Jugador votado = j.seleccionar(nominados); // Esto si hay interfaz no se usa es temporal
            this.votar( j, votado );
        }

        List<Voto> votos = urna.obtenerVotos();

        this.eliminarAlMasVotado();
        this.resultado = new ResultadoDiurno(votos, nominados);

    }

    @Override
    public Fase siguiente() {
        return new FaseNocturna();
    }

    @Override
    public Ronda actualizar(Ronda ronda) {
        return ronda.siguiente();
    }
}