package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private Rol rol;
    private boolean vivo;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.vivo = true;
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

    public boolean estaVivo() {
        return vivo;
    }

    public void eliminar() {
        vivo = false;
    }
}
