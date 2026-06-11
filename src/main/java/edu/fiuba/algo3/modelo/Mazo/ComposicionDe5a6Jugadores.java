package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class ComposicionDe5a6Jugadores implements EstrategiaDeComposicion {

    @Override
    public List<Rol> crearRoles(int jugadores) {
        List<Rol> roles = new ArrayList<>();

        roles.add(new Mafioso());

        if (Math.random() < 0.5)
            roles.add(new Detective());
        else
            roles.add(new Medico());

        while (roles.size() < jugadores) {
            roles.add(new Ciudadano());
        }

        return roles;
    }
}