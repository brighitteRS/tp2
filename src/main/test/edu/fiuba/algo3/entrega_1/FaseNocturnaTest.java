package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import static org.junit.jupiter.api.Assertions.*;


public class FaseNocturnaTest {

    @Test
    public void laMafiaPuedeSeleccionarUnaVictimaValida() {

        Jugador ciudadano = new Jugador("Ciudadano");
        ciudadano.asignarRol(new Ciudadano());

        Mafioso mafioso = new Mafioso();

        FaseNocturna fase = new FaseNocturna();

        mafioso.elegirVictima(ciudadano);
        mafioso.actuarNoche(fase);

        assertEquals(ciudadano, fase.obtenerVictimaMafia());
    }

    @Test
    public void laMafiaNoPuedeSeleccionarJugadorMuertoOMafioso() {

        Jugador muerto = new Jugador("Muerto");
        muerto.asignarRol(new Ciudadano());
        muerto.eliminar();

        Jugador otroMafiosoJugador = new Jugador("OtroMafioso");
        otroMafiosoJugador.asignarRol(new Mafioso());

        Mafioso mafioso = new Mafioso();

        FaseNocturna fase = new FaseNocturna();

        assertThrows(IllegalArgumentException.class, () -> {
            mafioso.elegirVictima(muerto);
            mafioso.actuarNoche(fase);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            mafioso.elegirVictima(otroMafiosoJugador);
            mafioso.actuarNoche(fase);
        });
    }

    @Test
    public void elMedicoSalvaAlJugadorAtacadoPorLaMafia() {

        Jugador victima = new Jugador("Victima");
        victima.asignarRol(new Ciudadano());

        Mafioso mafioso = new Mafioso();
        Medico medico = new Medico();

        FaseNocturna fase = new FaseNocturna();

        mafioso.elegirVictima(victima);
        medico.elegirProtegido(victima);

        mafioso.actuarNoche(fase);
        medico.actuarNoche(fase);

        fase.ejecutar();

        assertTrue(victima.estaVivo());
    }

    @Test
    public void laMafiaEliminaAlJugadorSiNoEstaProtegido() {

        Jugador victima = new Jugador("Victima");
        victima.asignarRol(new Ciudadano());

        Jugador otro = new Jugador("Otro");
        otro.asignarRol(new Ciudadano());

        Mafioso mafioso = new Mafioso();
        Medico medico = new Medico();

        FaseNocturna fase = new FaseNocturna();

        mafioso.elegirVictima(victima);
        medico.elegirProtegido(otro);

        mafioso.actuarNoche(fase);
        medico.actuarNoche(fase);

        fase.ejecutar();

        assertFalse(victima.estaVivo());
    }
}
