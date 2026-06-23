package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Mazo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Roles.Detective;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Roles.Medico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyList;


public class MazoTest {

    @Test
    public void test01MazoConSeisJugadoresTieneComposicionCorrecta() {

        // Arrange
        Mazo mazo = new Mazo(6);

        // Act
        long mafiosos = mazo.contarRolesDe(Mafioso.class);
        long especiales = mazo.contarRolesDe(Detective.class) + mazo.contarRolesDe(Medico.class);
        long ciudadanos = mazo.contarRolesDe(Ciudadano.class);
        int total = mazo.totalDeCartas();

        // Assert
        assertEquals(1, mafiosos);
        assertEquals(1, especiales);
        assertEquals(4, ciudadanos);
        assertEquals(6, total);
    }

    @Test
    public void test02VerificarQueElRepartoDeCartasSeaAleatorio() {
        // Arrange
        List<Rol> cartas = new ArrayList<>();
        cartas.add(new Mafioso());
        cartas.add(new Detective());
        cartas.add(new Ciudadano());
        cartas.add(new Ciudadano());
        cartas.add(new Ciudadano());
        cartas.add(new Ciudadano());
        List<Rol> copia = new ArrayList<>(cartas);

        // Act
        new Aleatorio().mezclar(copia);

        // Assert
        assertNotEquals(cartas, copia);
    }

    @Test
    public void test03CadaJugadorRecibeUnRol() {

        Mazo mazo = new Mazo(6);
        List<Jugador> jugadores = new ArrayList<>();

        mazo.repartir(6, jugadores);

        assertEquals(6, jugadores.size());
    }

    @Test
    public void test04JugadorSoloPuedeVerSuPropioRol() {

        Jugador ciudadano1 = new Jugador(new Ciudadano());
        Jugador ciudadano2 = new Jugador(new Ciudadano());

        Rol rolPropio = ciudadano1.consultarRol(ciudadano1);
        Rol rolAjeno = ciudadano1.consultarRol(ciudadano2);

        //no se si es lo mejor tener un getClass sino podemos preguntarle al jugador
        //si puedo ver su rol aunq esta comparacion es mas exacta la vd
        assertEquals(Ciudadano.class, rolPropio.getClass());
        assertEquals(RolNulo.INSTANCIA, rolAjeno);
    }

    //este test no se si es de bando sino poder preguntarle a un jugador si otro jugador es su
    //complice, por eso cada jugador mafioso o padrino debe almacenar sus complices y poder hacer

    /*@Test
    public void test05MafiososSeConocenEntreEllos() {
        // Arrange
        Jugador mafioso1 = new Jugador(new Mafioso());
        Jugador mafioso2 = new Jugador(new Mafioso());
        Jugador ciudadano = new Jugador(new Ciudadano());

        // Assert
        assertTrue(mafioso1.conocesA(mafioso2));
        assertFalse(mafioso1.conocesA(ciudadano));
    }*/

    @Test
    public void test05MafiososSeConocenEntreEllos() {
        // Arrange
        Jugador mafioso1 = new Jugador(new Mafioso());
        Jugador mafioso2 = new Jugador(new Mafioso());
        Jugador ciudadano = new Jugador(new Ciudadano());

        // Act
        Bando bandoComplice = mafioso1.consultarBando(mafioso2);
        Bando bandoCiudadano = mafioso1.consultarBando(ciudadano);

        // Assert
        assertEquals(BandoMafia.INSTANCIA, bandoComplice);
        assertEquals(BandoNulo.INSTANCIA, bandoCiudadano);
    }

}





