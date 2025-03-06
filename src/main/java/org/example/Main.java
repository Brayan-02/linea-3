package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String RESET = "\u001B[0m";
        final String ROJO = "\u001B[31m";
        final String AZUL = "\u001B[34m";
        final String CYAN = "\u001B[36m";
        final String VERDE = "\u001B[32m";

        Scanner sc = new Scanner(System.in);

        CuentaBancaria cuenta1 = new CuentaBancaria("Brayan2002", "Brayan Forigua", 2000);
        CuentaBancaria cuenta2 = new CuentaBancaria("valencia69", "Daniel Valencia", 5000);
        CuentaBancaria cuenta3 = new CuentaBancaria("andres203", "Andres Forero", 3000000.2);

        List<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);

        System.out.println(CYAN + "\t\t CAJERO" + RESET);

        int opcion1 = 0;

        while (opcion1 != 4) {
            System.out.println("Si no tienes cuenta creala o accede📱 ");
            System.out.println(AZUL + "1️⃣ Accede a tu Cuenta \n2️⃣ Ver Cuentas \n3️⃣ Crear Cuentas \n4️⃣ Salir" + RESET);
            opcion1 = sc.nextInt();

            switch (opcion1) {
                case 1 -> {
                    CuentaBancaria cuentaSeleccionada = null;
                    do {

                        System.out.println(VERDE + "Cuentas disponibles:" + RESET);
                        for (CuentaBancaria cuenta : cuentas) {
                            System.out.println("✔️ " + AZUL + cuenta.getNumeroCuenta() + RESET);
                        }

                        System.out.println("Ingresa el Serial de la cuenta con la que deseas operar:");
                        String numeroCuentaSeleccionada = sc.next();

                        for (CuentaBancaria cuenta : cuentas) {
                            if (cuenta.getNumeroCuenta().equals(numeroCuentaSeleccionada)) {
                                cuentaSeleccionada = cuenta;
                                break;
                            }
                        }

                        if (cuentaSeleccionada == null) {
                            System.out.println(ROJO + "❌ Cuenta no encontrada. ❌" + RESET);
                            continue;
                        }
                    }while (cuentaSeleccionada == null);
                    System.out.println("Has seleccionado la cuenta de: " + VERDE + cuentaSeleccionada.getTitular() + RESET);

                    int opcion = 0;
                    while (opcion != 4) {
                        System.out.println(VERDE + "¿Qué deseas hacer?" + RESET);
                        System.out.println(AZUL + "1️⃣Ingresar dinero\n2️⃣Retirar dinero\n3️⃣Mostrar información de la cuenta\n4️⃣Volver al menú principal" + RESET);
                        opcion = sc.nextInt();

                        switch (opcion) {
                            case 1 -> {
                                System.out.println(CYAN+ "¿Cuánto deseas ingresar?" + RESET);
                                double saldo = sc.nextDouble();
                                if(saldo <0){
                                    System.out.println(ROJO+ "❌valor no aceptado debe ser saldo positivo❌"+ RESET);
                                    opcion = 1;
                                }else{
                                    System.out.println(VERDE+ "✅Recarga exitosa ✅"+RESET);
                                    cuentaSeleccionada.ingresarSaldo(saldo);
                                    System.out.println(VERDE+ "Saldo actual: $" + cuentaSeleccionada.getSaldo());
                                    System.out.println(VERDE+ "---------------------------------"+RESET);
                                }

                            }
                            case 2 -> {
                                System.out.println("¿Cuánto deseas retirar?");
                                double saldo = sc.nextDouble();
                                if (cuentaSeleccionada.retirarSaldo(saldo)) {
                                    System.out.println(VERDE +"Retiro exitoso. Saldo actual: $" + cuentaSeleccionada.getSaldo()+RESET);
                                    System.out.println(VERDE+ "---------------------------------"+RESET);
                                } else {
                                    System.out.println(ROJO + "❌Fondos insuficientes.❌" + RESET);
                                    System.out.println(VERDE+ "---------------------------------"+RESET);
                                }
                            }
                            case 3 -> {
                                System.out.println("Información de la cuenta:");
                                System.out.println(CYAN + "--------------------------------------------------");
                                System.out.printf("| %-15s | %-15s | %-10s |\n", "Serial", "Titular", " Saldo");
                                System.out.println(CYAN + "--------------------------------------------------");
                                System.out.printf("| %-15s | %-15s | %-10s |\n",cuentaSeleccionada.getNumeroCuenta()
                                        ,cuentaSeleccionada.getTitular(),cuentaSeleccionada.getSaldo());
                                System.out.println(CYAN + "--------------------------------------------------");

                            }
                            case 4 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println(ROJO + "Opción no válida." + RESET);
                        }
                    }
                }
                case 2 -> {
                    System.out.println(VERDE + "Lista de Cuentas:" + RESET);
                    System.out.println(CYAN + "--------------------------------------------------");
                    System.out.printf("| %-15s | %-15s | %-10s |\n", "Serial", "Titular", " Saldo");
                    System.out.println(CYAN + "--------------------------------------------------");

                    for (CuentaBancaria cuenta : cuentas) {
                        System.out.printf("| %-15s | %-15s |$ %-10.1f |\n",
                                cuenta.getNumeroCuenta(),
                                cuenta.getTitular(),
                                cuenta.getSaldo());
                    }

                    System.out.println(CYAN + "--------------------------------------------------" + RESET);
                }

                case 3 -> {
                    sc.nextLine();
                    System.out.println(VERDE + "Creación de nueva cuenta." + RESET);
                    System.out.println("Ingresa el Serial de cuenta:");
                    String numCuenta = sc.nextLine();
                    System.out.println("Ingresa el nombre del titular:");
                    String titular = sc.nextLine();
                    System.out.println("Ingresa el saldo inicial:");
                    double saldoInicial = sc.nextDouble();
                    cuentas.add(new CuentaBancaria(numCuenta, titular, saldoInicial));
                    System.out.println(VERDE + "Cuenta creada exitosamente." + RESET);
                }
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println(ROJO + "Opción no válida." + RESET);
            }
        }
    }
}
