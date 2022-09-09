package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Insertamos nombre de los jugadores
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre jugador 1: ");
        Jugador jugador1 = new Jugador(scanner.nextLine());
        System.out.println("Ingrese nombre jugador 2: ");
        Jugador jugador2 = new Jugador(scanner.nextLine());


        //Insertamos el nombre del torneo
        System.out.println("Ingrese nombre del torneo: ");
        Torneo torneo = new Torneo(scanner.nextLine());

        //Cantidad de sets tiene que ser al mejor de 3 o 5
        System.out.println("Ingrese cantidad de sets: ");
        Integer cantidadSets = scanner.nextInt();
        if (cantidadSets != 3 && cantidadSets != 5) {
            System.out.println("Cantidad de sets incorrecta");
        } else {
            set(cantidadSets, jugador1, jugador2);
        }

        //Pedimos revancha
        System.out.println("Desea jugar otra vez? (s/n)");
        String respuesta = scanner.next();
        if (respuesta.equals("s")) {
            main(args);
        } else {
            System.out.println("Gracias por jugar");
        }



    }


    public static void probabilidadqueGane(Jugador jugador1, Jugador jugador2) {
        Random random = new Random();
        Integer probabilidadJugador1 = random.nextInt(100);
        Integer probabilidadJugador2 = random.nextInt(100);
        System.out.println("Probabilidad de ganar del jugador 1: " + probabilidadJugador1 + "%, del jugador 2: " + probabilidadJugador2 + "%");
    }

    public static boolean jugarPartidoDeTenis(Jugador jugador1, Jugador jugador2) {
        Random random = new Random();
        Integer contadorjugador1 = 0;
        Integer contadorjugador2 = 0;
        String puntosJugador1 = "0";
        String puntosJugador2 = "0";
        boolean ganador = true;
        boolean finPartido = false;

        while (finPartido != true) {

            Integer golpe = random.nextInt(2);
            String marcadorDePuntos = "";

            if (golpe == 0) {
                contadorjugador1 += 1;
            }

                if ((contadorjugador1 > 3) && (Math.abs(contadorjugador1 - contadorjugador2) > 1)) {
                    System.out.println();
                    System.out.println(jugador1 + " gana el partido");
                    System.out.println();
                    contadorjugador1 = 0;
                    contadorjugador2 = 0;
                    ganador = true;
                    finPartido = true;
                }

                if (golpe == 1) {
                    contadorjugador2 += 1;

                    if ((contadorjugador2 > 3) && (Math.abs(contadorjugador2 - contadorjugador1) > 1)) {
                        System.out.println();
                        System.out.println(jugador2 + " gana el partido");
                        System.out.println();
                        contadorjugador1 = 0;
                        contadorjugador2 = 0;
                        ganador = false;
                        finPartido = true;
                    }
                }

                if (contadorjugador1 == 1) {
                    puntosJugador1 = "15";
                    marcadorDePuntos = puntosJugador1 + " - " + puntosJugador2;
                }

                if (contadorjugador1 == 2) {
                    puntosJugador1 = "30";
                    marcadorDePuntos = puntosJugador1 + " - " + puntosJugador2;
                }

                if (contadorjugador1 == 3) {
                    puntosJugador1 = "40";
                    marcadorDePuntos = puntosJugador1 + " - " + puntosJugador2;
                }

                if (contadorjugador2 == 1) {
                    puntosJugador2 = "15";
                    marcadorDePuntos = puntosJugador1 + " - " + puntosJugador2;
                }

                if (contadorjugador2 == 2) {
                    puntosJugador2 = "30";
                    marcadorDePuntos = puntosJugador1 + " - " + puntosJugador2;
                }

                if (contadorjugador2 == 3) {
                    puntosJugador2 = "40";
                    marcadorDePuntos = puntosJugador1 + " - " + puntosJugador2;
                }

                if (contadorjugador1 > 3 && contadorjugador2 > 3 && puntosJugador1 == puntosJugador2) {
                    marcadorDePuntos = "Deuce";

                }

                if (contadorjugador1 > 3 && contadorjugador1 > contadorjugador2) {
                    puntosJugador1 = "";
                    puntosJugador2 = "";
                    marcadorDePuntos = "Ventaja " + jugador1;
                }

                if (contadorjugador2 > 3 && contadorjugador2 > contadorjugador1) {
                    puntosJugador1 = "";
                    puntosJugador2 = "";
                    marcadorDePuntos = "Ventaja " + jugador2;
                }

                System.out.println(marcadorDePuntos);

            }
        probabilidadqueGane(jugador1, jugador2);
        return ganador;
    }

    public static void set(float sets, Jugador jugador1, Jugador jugador2) {
        Integer juegosGanadosJugador1 = 0;
        Integer juegosGanadosJugador2 = 0;
        Integer setsGanadosJugador1 = 0;
        Integer setsGanadosJugador2 = 0;
        float contadorSets = (sets / 2) + 0.5f;
        boolean finDelJuego = false;

        while (!finDelJuego) {
            boolean resultado = jugarPartidoDeTenis(jugador1, jugador2);
            if (resultado) {
                juegosGanadosJugador1 += 1;
            } else {
                juegosGanadosJugador2 += 1;
            }
            if (juegosGanadosJugador1 == 6 && juegosGanadosJugador2 == 6) {
                System.out.println("Empate");
            }

            if (juegosGanadosJugador1 >= 6 && (Math.abs(juegosGanadosJugador1 - juegosGanadosJugador2) > 1) || juegosGanadosJugador1 == 7 && juegosGanadosJugador2 == 6) {
                setsGanadosJugador1 += 1;
                System.out.println(jugador1+ " gana el set por " + juegosGanadosJugador1 + " a " + juegosGanadosJugador2);
                System.out.println();
                juegosGanadosJugador1 = 0;
                juegosGanadosJugador2 = 0;
                if (setsGanadosJugador1 == contadorSets && setsGanadosJugador1 > setsGanadosJugador2) {
                    System.out.println(jugador1 + " gana el partido por " + setsGanadosJugador1 + " sets a " + setsGanadosJugador2);
                    finDelJuego = true;
                }
            }
            if (juegosGanadosJugador2 >= 6 && (Math.abs(juegosGanadosJugador2 - juegosGanadosJugador1) > 1) || juegosGanadosJugador2 == 7 && juegosGanadosJugador1 == 6) {
                setsGanadosJugador2 += 1;
                System.out.println(jugador2 + " gana el set por " + juegosGanadosJugador2 + " a " + juegosGanadosJugador1);
                System.out.println();
                juegosGanadosJugador1 = 0;
                juegosGanadosJugador2 = 0;
                if (setsGanadosJugador2 == contadorSets && setsGanadosJugador2 > setsGanadosJugador1) {
                    System.out.println(jugador2 + " gana el partido por " + setsGanadosJugador2 + " sets a " + setsGanadosJugador1);
                    finDelJuego = true;
                }
            }
        }
    }

}