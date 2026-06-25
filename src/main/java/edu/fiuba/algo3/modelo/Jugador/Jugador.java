package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jugador {

    private final Rol rol;
    private EstadoJugador estado;
    private EstadoCarta carta;

    public Jugador(Rol rol) {
        this.rol = rol;
        this.estado = new Vivo();
        this.carta = new CartaOculta();
    }

    public boolean estaVivo() {
        return estado.estaVivo();
    }

    public void eliminar() {
        this.estado = new Muerto();
        revelarCarta();
    }

    public void revelarCarta() {
        this.carta = new CartaRevelada();
    }

    public Bando consultarBando(Jugador solicitante) {
        return carta.consultarBando(rol, this, solicitante);
    }

    public Rol consultarRol(Jugador solicitante) {
        return carta.consultarRol(rol, this, solicitante);
    }

    public void elegir(Jugador objetivo) {
        estado.validarPuedeActuar();
        objetivo.validarPuedeSerObjetivo();
        rol.elegir(objetivo);
    }

    public Jugador seleccionar(List<Jugador> jugadores) {
        // Metodo que se usa para los tests, cuando tengamos interfaz se elimina
        if (jugadores.isEmpty()) {
            return JugadorNulo.INSTANCIA;
        }

        Random random = new Random();
        return jugadores.get(random.nextInt(jugadores.size()));
    }

    public void actuarDeNoche(ResultadoNocturno resultado) {
        estado.validarPuedeActuar();
        rol.actuarDeNoche(resultado);
    }

    public void actuarComoDetective(ResultadoNocturno resultado) {
        estado.validarPuedeActuar();
        rol.actuarDetective(resultado);
    }

    public void actuarComoMedico(ResultadoNocturno resultado) {
        estado.validarPuedeActuar();
        rol.actuarMedico(resultado);
    }

    public Bando resultadoInvestigacion() {
        estado.validarPuedeActuar();
        return rol.obtenerResultado();
    }

    public Bando revelarBandoAInvestigacion() {
        return rol.revelarBandoInvestigado();
    }

    public void guardarVotoNocturno(Urna urna) {
        estado.validarPuedeActuar();
        rol.votar(this, urna);
    }

    public Jugador obtenerVotoPrioritario() {
        estado.validarPuedeActuar();
        return rol.votoPrioritario();
    }

    public void registrarseEnMafia(RegistroMafia registro) {
        estado.validarPuedeActuar();
        rol.registrarseEnMafia(this, registro);
    }

    public void recibirComplices(List<Jugador> mafiosos) {
        estado.validarPuedeActuar();
        rol.recibirComplices(this, mafiosos);
    }

    public boolean conoceA(Jugador otro) {
        estado.validarPuedeActuar();
        return rol.conoceA(this, otro);
    }

    public boolean perteneceA(Bando bando) {
        return rol.revelarBando().equals(bando);
    }

    public void validarPuedeSerVictimaDeMafia() {
        rol.validarPuedeSerVictimaDeMafia();
    }

    public void validarPuedeSerObjetivo() {
        estado.validarPuedeSerObjetivo();
    }

    public void validarSiPuedeActuar() {
        estado.validarPuedeActuar();
    }
}