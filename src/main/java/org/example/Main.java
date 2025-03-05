package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ram = new Random();
        RuletaRusa ruleta = new RuletaRusa();

        int numeroJugador;
        int jugadorActual;
        int jugadorInicial;

        System.out.println("RULETA RUSA");
        System.out.println("¿Cuántos jugadores jugarán?");
        numeroJugador = sc.nextInt();

        boolean[] jugadoresVivos = new boolean[numeroJugador + 1];
        for (int i = 1; i <= numeroJugador; i++) {
            jugadoresVivos[i] = true;
        }

        boolean seguirJugando = true;

        while (seguirJugando) {

            do {
                jugadorInicial = ram.nextInt(numeroJugador) + 1;
            } while (!jugadoresVivos[jugadorInicial]);

            jugadorActual = jugadorInicial;

            boolean alguienMuerto = false;
            int disparosRealizados = 0;

            do {
                System.out.println("Turno del jugador: " + jugadorActual);
                disparosRealizados++;
                System.out.println(ruleta.toString());

                boolean disparo = ruleta.disparar();

                if (disparosRealizados == 6) {
                    System.out.println("Jugador " + jugadorActual + " ha muerto (la bala estaba en el último disparo).");
                    jugadoresVivos[jugadorActual] = false;
                    alguienMuerto = true;
                    ruleta.reiniciarJuego();
                } else if (disparo) {
                    System.out.println("Jugador " + jugadorActual + " ha muerto.");
                    jugadoresVivos[jugadorActual] = false;
                    alguienMuerto = true;
                    ruleta.reiniciarJuego();
                } else {
                    System.out.println("Jugador " + jugadorActual + " se ha salvado.");

                    do {
                        jugadorActual++;
                        if (jugadorActual > numeroJugador) {
                            jugadorActual = 1;
                        }
                    } while (!jugadoresVivos[jugadorActual]);
                }

                if (alguienMuerto) {
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
                            ruleta.reiniciarJuego();
                        }
                    }
                }

            } while (!alguienMuerto && disparosRealizados < 6);

            System.out.println("Fin de la ronda.");
        }

        System.out.println("Juego terminado.");
    }
}
