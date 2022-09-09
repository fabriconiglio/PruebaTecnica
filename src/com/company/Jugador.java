package com.company;

public class Jugador {
    private String nombre;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
    }

    @Override
    public String toString() {
        return "Jugador:" + nombre ;
    }
}
