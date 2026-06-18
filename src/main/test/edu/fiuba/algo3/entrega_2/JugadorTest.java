package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.FaseNocturna.Mafia;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void jugadorEliminadoPuedeRevelarSuRol() {
        //arrange
        Rol rolCiudadano = new Ciudadano();
        Mafia mafia = new Mafia();
        Mafioso mafioso = new Mafioso();
        Jugador victima = new Jugador(rolCiudadano);
        Jugador jugador2 = new Jugador(new Ciudadano());
        FaseNocturna fase = new FaseNocturna(mafia, List.of());

        //act
        mafioso.elegirVictima(victima);
        mafia.recolectarVotos(List.of(mafioso));
        fase.ejecutar();

        //assert
        assertEquals(rolCiudadano, jugador2.consultarRol(victima));
    }

    @Test
    public void jugadorNoEliminadoNoPuedeRevelarSuRol() {
        //arrange
        Rol rolCiudadano = new Ciudadano();
        Mafia mafia = new Mafia();
        Mafioso mafioso = new Mafioso();
        Jugador victima = new Jugador(rolCiudadano);
        Jugador jugador2 = new Jugador(new Ciudadano());
        Jugador jugador3 = new Jugador(new Ciudadano());
        FaseNocturna fase = new FaseNocturna(mafia, List.of());

        //act
        mafioso.elegirVictima(victima);
        mafia.recolectarVotos(List.of(mafioso));
        fase.ejecutar();

        //assert
        assertEquals(null, jugador2.consultarRol(jugador3));
    }
}
