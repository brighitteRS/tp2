/*package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;

public class FaseDiurna {

    private Urna urna;

    public FaseDiurna() {
        this.urna = new Urna();
    }

    public FaseDiurna(Urna urna) {
        this.urna = urna;
    }

    public void iniciarDebate(int tiempo) {

    }

    public List<Jugador> obtenerNominados() {
        return urna.obtenerCandidatos();
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

}
*/