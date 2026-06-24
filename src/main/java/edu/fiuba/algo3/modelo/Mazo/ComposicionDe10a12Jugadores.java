package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.Jugador.Rol;
import edu.fiuba.algo3.modelo.Roles.*;

import java.util.ArrayList;
import java.util.List;

public class ComposicionDe10a12Jugadores implements EstrategiaDeComposicion {

    @Override
    public List<Rol> crearRoles(int cantidadJugadores) {
        List<Rol> roles = new ArrayList<>();

        roles.add(new Mafioso());
        roles.add(new Mafioso());
        roles.add(new Mafioso());
        roles.add(new Detective());
        roles.add(new Medico());
        roles.add(new Padrino());
        roles.add(new Sheriff());

        while (roles.size() < cantidadJugadores) {
            roles.add(new Ciudadano());
        }


        return roles;
    }
}
