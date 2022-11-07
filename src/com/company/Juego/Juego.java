package com.company.Juego;

import java.io.PrintStream;
import java.util.Random;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;

    public Juego(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public Jugador jugar() {
        Integer diferencia = 1;

        do{
            do {
                this.juegan();
                this.muestraMensaje();
                if (this.jugador1.getPuntos() == 3 && this.jugador2.getPuntos() == 3 && diferencia == 1) {
                    diferencia++;
                }

                if (this.jugador1.getPuntos() == 6 && this.jugador2.getPuntos() == 6) {
                    System.out.println("Se juega un tie break");
                    Jugador ganador = this.jugarTieBreaks();
                    ganador.setPuntos(ganador.getPuntos() + 1);
                    return ganador;
                }

            } while (Math.abs(this.jugador1.getPuntos() - this.jugador2.getPuntos()) < diferencia);
            } while (this.jugador1.getPuntos() < 6 && this.jugador2.getPuntos() < 6);

            return this.jugador1.getPuntos() - this.jugador2.getPuntos() > 0 ? this.jugador1 : this.jugador2;
    }


    private boolean ganaElJuego(Integer probabilidadDeGanar) {

        Random random = new Random();
        Integer valor = random.nextInt(100) + 1;
        return valor < probabilidadDeGanar - 1;
    }

    private void juegan() {
        if (this.ganaElJuego(this.jugador1.getProbabilidadDeGanar())) {
            this.jugador1.setPuntos(this.jugador1.getPuntos() + 1);
        } else {
            this.jugador2.setPuntos(this.jugador2.getPuntos() + 1);
        }
    }

    private void muestraMensaje() {
        PrintStream salida = System.out;
        String nombreJugador = this.jugador1.getNombre();
        salida.println("||" + nombreJugador + " --- " + this.jugador2.getNombre() + "||");
        salida = System.out;
        Integer var1 = this.jugador1.getPuntos();
        salida.println("||    " + var1 + " --- " + this.jugador2.getPuntos() + "    ||");
    }

    private void muestraMensajeDePuntoDeQuiebre() {
        PrintStream salida = System.out;
        String nombreJugador = this.jugador1.getNombre();
        salida.println("||" + nombreJugador + " --- " + this.jugador2.getNombre() + "||");
        salida = System.out;
        Integer var1 = this.jugador1.getPuntoDeQuiebre();
        salida.println("||    " + var1 + " --- " + this.jugador2.getPuntoDeQuiebre() + "    ||");
    }

    private void jugarTieBreak() {
        if (this.ganaElJuego(this.jugador1.getProbabilidadDeGanar())) {
            this.jugador1.setPuntoDeQuiebre(this.jugador1.getPuntoDeQuiebre() + 1);
        } else {
            this.jugador2.setPuntoDeQuiebre(this.jugador2.getPuntoDeQuiebre() + 1);
        }
    }

    private Jugador jugarTieBreaks() {

        String jugarParaSacar = this.jugador1.getNombre();

        do {
            this.jugarTieBreak();
            this.muestraMensajeDePuntoDeQuiebre();
        } while (this.jugador1.getPuntoDeQuiebre() < 7 && this.jugador2.getPuntoDeQuiebre() < 7);

        return this.jugador1.getPuntoDeQuiebre() - this.jugador2.getPuntoDeQuiebre() > 0 ? this.jugador1 : this.jugador2;
    }


}
