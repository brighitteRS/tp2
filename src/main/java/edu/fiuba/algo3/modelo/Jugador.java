package edu.fiuba.algo3.modelo;

public class Jugador {

    private String nombre;
    private Rol rol;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public void asignarRol(Rol rol){
        this.rol = rol;
    }

    public boolean Rol tieneRolAsignado() {
        return rol != null;
    }


}
