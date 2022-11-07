package com.company.Juego;

import com.company.Exceptions.TenisExceptions;

import java.io.PrintStream;
import java.util.ArrayList;

public class Set {

    private String nombreDelTorneo;
    private ArrayList<Juego> juegos;
    private String totalPuntosJugador1;
    private String totalPuntosJugador2;

    public Set(String nombreDelTorneo) {
        this.nombreDelTorneo = nombreDelTorneo;
        this.juegos = new ArrayList<>();
        this.totalPuntosJugador1 = "";
        this.totalPuntosJugador2 = "";
    }

    public Jugador jugar(Jugador jugador1, Jugador jugador2,Double setJugando) throws TenisExceptions {

        Juego juego = new Juego(jugador1, jugador2);

        Boolean saca = true;

        for (int i=0; i<setJugando; i++) {

            if (saca) {
                System.out.println("Saca " + jugador1.getNombre());
            } else {
                System.out.println("Saca " + jugador2.getNombre());
            }

            Jugador ganador = juego.jugar();
            String valor = this.totalPuntosJugador1;
            this.totalPuntosJugador1 = valor + jugador1.getPuntos();
            valor = this.totalPuntosJugador2;
            this.totalPuntosJugador2 = valor + jugador2.getPuntos();
            ganador.setSets(ganador.getSets() + 1);

            System.out.println("================================");
            System.out.println("Gana el set " + ganador.getNombre());
            PrintStream salida = System.out;
            valor = jugador1.getNombre();
            salida.println(valor + "                  " + this.getTotalPuntosJugador1());
            salida = System.out;
            valor = jugador2.getNombre();
            salida.println(valor + "                  " + this.getTotalPuntosJugador2());
            jugador1.resetearPuntos();
            jugador2.resetearPuntos();

            if(jugador1.getSets() == Math.ceil(setJugando/2.0)) {
                return jugador1;
            }

            if(jugador2.getSets() == Math.ceil(setJugando/2.0)) {
                return jugador2;
            }

            if (saca) {
                saca = false;
            } else {
                saca = true;
            }

        }

        throw new TenisExceptions("Hay un error en la aplicación");
    }

    public String getNombreDelTorneo() {
        return nombreDelTorneo;
    }

    public void setNombreDelTorneo(String nombreDelTorneo) {
        this.nombreDelTorneo = nombreDelTorneo;
    }

    public String getTotalPuntosJugador1() {
        return totalPuntosJugador1;
    }

    public void setTotalPuntosJugador1(String totalPuntosJugador1) {
        this.totalPuntosJugador1 = totalPuntosJugador1;
    }

    public String getTotalPuntosJugador2() {
        return totalPuntosJugador2;
    }

    public void setTotalPuntosJugador2(String totalPuntosJugador2) {
        this.totalPuntosJugador2 = totalPuntosJugador2;
    }
}
