package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;

public class Ronda {

    private final int numero;

    public Ronda(int numero) {
        this.numero = numero;
    }

    private ResultadoNocturno resultadoNocturno;
    //private ResultadoDiurno resultadoDia;

    public Ronda siguiente() {
        return new Ronda(numero + 1);
    }

    public int obtenerNumero() {
        return numero;
    }

    public void registrarResultadoNocturno(ResultadoNocturno resultado) {
        this.resultadoNocturno = resultado;
    }

    public ResultadoNocturno obtenerResultadoNocturno() {
        return resultadoNocturno;
    }

    /*public void registrarResultadoDiurno(ResultadoDiurno resultado) {
        this.resultadoDiurno = resultado;
    }
    public ResultadoDiurno obtenerResultadoDiurno() {
        return resultadoDiurno;
    }
    */
}