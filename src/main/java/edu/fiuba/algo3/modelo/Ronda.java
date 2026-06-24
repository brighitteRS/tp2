package edu.fiuba.algo3.modelo;

public class Ronda {

    private final int numero;

    public Ronda(int numero) {
        this.numero = numero;
    }

    public Ronda siguiente() {
        return new Ronda(numero + 1);
    }

    public int numero() {
        return numero;
    }
}