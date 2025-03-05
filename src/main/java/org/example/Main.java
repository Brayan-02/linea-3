package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final String RESET = "\u001B[0m";
        final String ROJO = "\u001B[31m";
        final String AZUL = "\u001B[34m";
        final String CYAN = "\u001B[36m";
        final String VERDE = "\u001B[32m";

        Scanner sc = new Scanner(System.in);
        Random ram = new Random();
        RuletaRusa ruleta = new RuletaRusa();

        System.out.println(CYAN + "\t🎰RULETA RUSA🎰" + RESET);
        System.out.println(AZUL + "¿Cuántos jugadores jugarán?" + RESET);
        int numeroJugador = sc.nextInt();

        boolean[] jugadoresVivos = new boolean[numeroJugador + 1];
        for (int i = 1; i <= numeroJugador; i++) {
            jugadoresVivos[i] = true;
        }

        boolean seguirJugando = true;

        while (seguirJugando) {

            int jugadorActual;
            do {
                jugadorActual = ram.nextInt(numeroJugador) + 1;
            } while (!jugadoresVivos[jugadorActual]);
            ruleta.reiniciarJuego();

            boolean alguienMuerto = false;

            while (!alguienMuerto) {
                System.out.println(VERDE+ "Turno del jugador: " + jugadorActual + RESET);
                System.out.println("Di si 😥 para disparar 🎆");

                String respuesta1 = sc.next();
                if (respuesta1.equalsIgnoreCase("si")) {
                    if (ruleta.disparar()) {
                        System.out.println(AZUL+ "Jugador " + jugadorActual + " ha muerto.☠️" +RESET);
                        System.out.println(ruleta.toString());
                        jugadoresVivos[jugadorActual] = false;
                        alguienMuerto = true;
                        System.out.println(ROJO+"-------------------------------"+RESET);
                    } else {
                        System.out.println(AZUL+ "Jugador " + jugadorActual + " se ha salvado.🎉"+RESET);
                        System.out.println(ROJO+"-------------------------------"+RESET);
                    }

                    if (!alguienMuerto) {
                        do {
                            jugadorActual++;
                            if (jugadorActual > numeroJugador) {
                                jugadorActual = 1;
                            }
                        } while (!jugadoresVivos[jugadorActual]);
                    }
                } else {
                    System.out.println(ROJO + "Gallina🐔 igual tendrás que disparar🔫 " + RESET);
                }
            }
            int vivos = 0;
            for (int i = 1; i <= numeroJugador; i++) {
                if (jugadoresVivos[i]) {
                    vivos++;
                }
            }

            if (vivos <= 1) {
                System.out.println("Solo queda un jugador vivo. Fin del juego.");
                seguirJugando = false;
            } else {
                System.out.println("¿Desean seguir jugando? (si/no)");
                String respuesta = sc.next();
                if (!respuesta.equalsIgnoreCase("si")) {
                    seguirJugando = false;
                }
            }

            System.out.println("Fin de la ronda.");
        }

        System.out.println("Juego terminado.");
    }
}
