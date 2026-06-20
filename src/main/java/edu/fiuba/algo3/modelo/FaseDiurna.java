package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Urna.SistemaNominaciones;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;

public class FaseDiurna {

    private Urna urna;
    private SistemaNominaciones nominaciones;

    public FaseDiurna() {
        this.urna = new Urna();
        this.nominaciones = new SistemaNominaciones();
    }

    public FaseDiurna(SistemaNominaciones nominaciones) {
        this.urna = new Urna();
        this.nominaciones = nominaciones;
    }

    public FaseDiurna(Urna urna, SistemaNominaciones nominaciones) {
        this.urna = urna;
        this.nominaciones = nominaciones;
    }

    public FaseDiurna(Urna urna) {
        this.urna = urna;
    }

    public void iniciarDebate(int tiempo) {
        // Aca se deberia mostrar el tiempo en la interfaz grafica y que se puedan comunicar los vivos
    }

    public void nominar( Jugador jugadorANominar ) {
        if ( !jugadorANominar.estaVivo() ) {
            throw new IllegalArgumentException("No se puuede nominar a un jugador muerto");
        }
        nominaciones.agregarCandidato(jugadorANominar);
    }

    public void votar(Jugador votador, Jugador votado) {
        if ( !votador.estaVivo() ){
            throw new IllegalArgumentException("Un jugador muerto no puede votar");
        } else if ( !nominaciones.esCandidato(votado) ) {
            throw new IllegalArgumentException("No se pueden votar jugadores que no son candidatos durante la fase diurna");
        }
        urna.registrarVoto( votador, votado );
    }

    public Jugador eliminarAlMasVotado(){
        List<Jugador> ganadores = urna.getGanadores();

        if ( ganadores.size() > 1  ) {
            return null;
        }

        Jugador eliminado = ganadores.get(0);
        eliminado.cambiarEstado(new Muerto());
        return eliminado;
    }

    public List<Jugador> obtenerNominados() {
        return nominaciones.obtenerCandidatos();
    }

}
