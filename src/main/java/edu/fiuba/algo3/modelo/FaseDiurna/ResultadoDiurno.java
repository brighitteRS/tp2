package edu.fiuba.algo3.modelo.FaseDiurna;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Urna.Voto;

import java.util.ArrayList;
import java.util.List;

public class ResultadoDiurno {
//    private int ronda;
    private List<Jugador> nominados;
    private List<Voto> votos;

    public ResultadoDiurno(List<Voto> votos, List<Jugador> nominados) {
//        this.ronda = ronda;
        this.nominados = nominados;
        this.votos = votos;
    }
//
//    public ResultadoDiurno(int ronda) {
////        this.ronda = ronda;
//        this.nominados = new ArrayList<>();
//        this.votos = new ArrayList<>();
//    }

    public void registrarNominado(Jugador nominado) {
        this.nominados.add(nominado);
    }

    public void registrarVoto(Voto voto) {
        this.votos.add(voto);
    }

}
