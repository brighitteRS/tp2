package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.RegistroMafia;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MiembroDeLaMafia extends Rol {

    private Jugador victimaElegida = JugadorNulo.INSTANCIA;
    private List<Jugador> complices = new ArrayList<>();

    protected MiembroDeLaMafia() {
        super(BandoMafia.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    protected boolean esComplice(Jugador jugador) {
        return complices.contains(jugador);
    }

    @Override
    public boolean conoceA(Jugador self, Jugador otro) {
        return esComplice(otro);
    }

    @Override
    public void elegir(Jugador objetivo) {
        objetivo.validarPuedeSerVictimaDeMafia();
        victimaElegida = objetivo;
    }

    protected Jugador victimaElegida() {
        return victimaElegida;
    }

    @Override
    public void votar(Jugador self, Urna urna) {
        urna.registrarVoto(self, victimaElegida);
    }

    @Override
    public void validarPuedeSerVictimaDeMafia() {
        throw new IllegalArgumentException();
    }

    @Override
    public void registrarseEnMafia(Jugador self, RegistroMafia registro) {
        registro.registrar(self);
    }

    @Override
    public void recibirComplices(Jugador self, List<Jugador> mafiosos) {
        this.complices = mafiosos.stream()
                .filter(jugador -> jugador != self)
                .collect(Collectors.toList());
    }
}