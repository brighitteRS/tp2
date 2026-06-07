package edu.fiuba.algo3.modelo;

public class Jugador {

    private String nombre;
    private Rol rol;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public void setRol(Rol rol){
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }


}
