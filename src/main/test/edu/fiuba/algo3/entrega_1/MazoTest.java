package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Mazo.*;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MazoTest {

    @Test
    public void test01MazoConSeisJugadoresTieneComposicionCorrecta() {

        Mazo mazo = new Mazo(6);

        assertEquals(1, mazo.contarRolesDe(Mafioso.class));
        assertEquals(1, mazo.contarRolesDe(Detective.class) + mazo.contarRolesDe(Medico.class));
        assertEquals(4, mazo.contarRolesDe(Ciudadano.class));
        assertEquals(6, mazo.totalDeCartas());
    }

    @Test
    public void test02CadaJugadorRecibeExactamenteUnRol() {

        Mazo mazo = new Mazo(6);

        int cartasIniciales = mazo.totalDeCartas();

        List<Rol> repartidas = new ArrayList<>();

        while (mazo.tieneCartas()) {
            repartidas.add(mazo.sacarCarta());
        }

        assertEquals(cartasIniciales, repartidas.size());
        assertEquals(0, mazo.totalDeCartas());
    }

    @Test
    public void test03JugadorSoloPuedeVerSuPropioRol() {

        Jugador ciudadano1 = new Jugador(new Ciudadano());
        Jugador ciudadano2 = new Jugador(new Ciudadano());

        Rol rolPropio = ciudadano1.consultarRol(ciudadano1);
        Rol rolAjeno = ciudadano1.consultarRol(ciudadano2);

        assertEquals(Ciudadano.class, rolPropio.getClass());
        assertEquals(RolNulo.INSTANCIA, rolAjeno);
    }

    @Test
    public void test04MafiososConocenASusComplices() {

        RegistroMafia registro = new RegistroMafia();

        Jugador mafioso1 = new Jugador(new Mafioso());
        Jugador mafioso2 = new Jugador(new Mafioso());

        registro.registrar(mafioso1);
        registro.registrar(mafioso2);

        registro.informarComplices();

        assertTrue(mafioso1.conoceA(mafioso2));
        assertTrue(mafioso2.conoceA(mafioso1));
    }

    @Test
    public void test05MafiosoNoConoceACiudadano() {

        RegistroMafia registro = new RegistroMafia();

        Jugador mafioso = new Jugador(new Mafioso());
        Jugador ciudadano = new Jugador(new Ciudadano());

        registro.registrar(mafioso);

        registro.informarComplices();

        assertFalse(mafioso.conoceA(ciudadano));
    }

    @Test
    public void soloLaMafiaConoceSusComplices() {

        RegistroMafia registro = new RegistroMafia();

        Jugador ciudadano1 = new Jugador(new Ciudadano());
        Jugador ciudadano2 = new Jugador(new Ciudadano());

        registro.registrar(ciudadano1);
        registro.registrar(ciudadano2);

        registro.informarComplices();

        assertFalse(ciudadano1.conoceA(ciudadano2));
    }
}



