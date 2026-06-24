package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.Jugador.Rol;
import java.util.List;

public interface EstrategiaDeComposicion {
    List<Rol> crearRoles(int jugadores);
}
