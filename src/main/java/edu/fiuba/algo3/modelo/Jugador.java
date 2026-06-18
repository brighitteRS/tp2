package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Urna.Urna;

public class Jugador {

    private final String nombre;
    private Rol rol;
    private boolean vivo;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vivo = true;
    }

    public Jugador(String nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public Jugador(String nombre, Rol rol, Boolean vivo) {
        this.nombre = nombre;
        this.rol = rol;
        this.vivo = vivo;
    }
    public void asignarRol(Rol rol) {
        this.rol = rol;
    }

    public boolean tieneRolAsignado() {
        return rol != null;
    }

    public Bando consultarBando(Jugador solicitante) {

        if (solicitante == this) {
            return rol.revelarBando();
        }
        return rol.revelarBandoA(solicitante);
    }

    public boolean estaVivo() {
        return vivo;
    }

    public Jugador eliminar() {
        vivo = false;
        return this;
    }

    public boolean puedeSerVictima() {
        return vivo && !rol.esDeLaMafia(); //se lo pregunta asi mismo
    }

    public void elegirVictima(Jugador victima) {
        rol.elegirVictima(victima);
    }

    public boolean esDeLaMafia() {
        return rol.esDeLaMafia();
    }

    public void ejecutarAccionNocturna(FaseNocturna fase) {
        if (rol instanceof ActorNocturno) {
            ((ActorNocturno) rol).actuarNoche(fase); //solo lo ejecuta si es un actor nocturno
        }
    }

    public void elegirProtegido(Jugador protegido) {
        rol.elegirProtegido(protegido);
    }

    public void nominar( Urna urna, Jugador nuevoCandidato ) {
        urna.agregarCandidato(nuevoCandidato);
    }

    public void votar(Urna urna, Jugador votado) {
        urna.registrarVoto(this, votado);
    }

    public Rol revelarRol() {
        return rol;
    }

}
