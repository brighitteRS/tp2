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

    public boolean tieneRolAsignado() {
        return rol != null;
    }

    public Bando consultarBando(Jugador solicitante){

        if (solicitante == this){
            return rol.revelarBando();
        }
        return rol.revelarBandoA(solicitante);
    }
    public boolean esDeLaMafia(){
        return rol.esDeLaMafia();
    }


}
