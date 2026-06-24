package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.Jugador.Rol;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Roles.Detective;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Roles.Medico;

import java.util.ArrayList;
import java.util.List;

public class ComposicionDe5a6Jugadores implements EstrategiaDeComposicion {

    @Override
    public List<Rol> crearRoles(int cantidadJugadores) {

        List<Rol> roles = new ArrayList<>();
        roles.add(new Mafioso());

        if (Math.random() < 0.5)
            roles.add(new Detective());
        else
            roles.add(new Medico());

        if (Math.random() < 0.5)
            roles.add(new Mafioso());
        else
            roles.add(new Ciudadano());

        while (roles.size() < cantidadJugadores) {
            roles.add(new Ciudadano());
        }

        return roles;
    }
}