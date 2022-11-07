package com.company;


import com.company.Exceptions.TenisExceptions;
import com.company.Juego.Jugador;
import com.company.Juego.Set;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws TenisExceptions {

        Scanner scanner = new Scanner(System.in);

        Integer revancha = 0;

        do{
            System.out.println();
            System.out.println("Ingrese el nombre del Torneo: ");
            String nombreDelTorneo = scanner.nextLine();
            System.out.println("Ingrese el nombre del Jugador 1: ");
            String nombreJugador1 = scanner.nextLine();
            System.out.println("Ingrese la probabilidad de ganar del Jugador 1: ");
            Integer probabilidad = scanner.nextInt();
            scanner.nextLine();
            Jugador jugador1 = new Jugador(nombreJugador1, probabilidad);
            System.out.println("Ingrese el nombre del Jugador 2: ");
            String nombreJugador2 = scanner.nextLine();
            System.out.println("Ingrese la probabilidad de ganar del Jugador 2: " + (100 - probabilidad));
            probabilidad = 100 - probabilidad;
            Jugador jugador2 = new Jugador(nombreJugador2, probabilidad);

            Double mejorDe;

            do {
                System.out.println("Seleccione el mejor de 3, 5:  ");
                mejorDe = scanner.nextDouble();

            } while (!(mejorDe == 3 || mejorDe == 5));

            Set set = new Set(nombreDelTorneo);
            Jugador ganador = set.jugar(jugador1, jugador2, mejorDe);
            System.out.println("================================");
            System.out.println("Final -  " + nombreDelTorneo + "    Finalizado");
            PrintStream salida = System.out;
            String nombreJugador = jugador1.getNombre();
            salida.println(nombreJugador + "                  " + set.getTotalPuntosJugador1());
            salida = System.out;
            nombreJugador = jugador2.getNombre();
            salida.println(nombreJugador + "                  " + set.getTotalPuntosJugador2());
            System.out.println("Ganador: " + ganador.getNombre());
            System.out.println("================================");

            do{
                try {
                    System.out.println("Desea jugar una revancha? 1: Si, 2: No");
                    revancha = scanner.nextInt();
                    scanner.nextLine();
                }catch (Exception e){
                    System.out.println("Ingrese un valor valido");
                    return;
                }
            } while (revancha != 1 && revancha != 2);

        } while (revancha == 1);

    }
}