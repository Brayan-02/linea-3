package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*moneda1=$20
          moneda2=$50
          moneda3=$100
          moneda4=$200
          moneda5=$500
         */
        int moneda1=0,moneda2=0,moneda3=0,moneda4=0,moneda5=0,total=0,opcion=0,opcion1=0, moneda=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("programa para determinar cunato dinero tienes");

        do{
            System.out.println("QUE deseas hacer? \n 1.agregar dinero \n 2.contar por denominacion \n 3.total ahorrado \n 4.vaciar \n 5.para vaciar ");
            opcion= sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("de que valor ingresaras el dinero? \n 1. $20 \n 2. $50 \n 3. $100 \n 4. $200 \n 5. $500");
                    opcion1=sc.nextInt();
                    switch (opcion1){
                        case 1:
                            moneda1++;
                            break;
                        case 2:
                            moneda2++;
                            break;
                        case 3:
                            moneda3++;
                            break;
                        case 4:
                            moneda4++;
                            break;
                        case 5:
                            moneda5++;
                            break;
                        default:
                            System.out.println("esta moneda no se puede ingresaar");
                            break;

                    }
                    break;
                case 2:
                    System.out.println("de que denominacion quieres saber cuantas tienes? \n recuerda 20,50,100,200,500" );
                    moneda = sc.nextInt();
                    switch (moneda){
                        case 20:
                            System.out.println("tienes "+ moneda1 + " monedas de $20 lo que equivale a: $" + (moneda1*20));
                            break;
                        case 50:
                            System.out.println("tienes "+ moneda2 + " monedas de $50 lo que equivale a: $" + (moneda2*50));
                            break;
                        case 100:
                            System.out.println("tienes "+ moneda3 + " monedas de $100 lo que equivale a: $" + (moneda3*100));
                            break;
                        case 200:
                            System.out.println("tienes "+ moneda4 + " monedas de $200 lo que equivale a: $" + (moneda4*200));
                            break;
                        case 500:
                            System.out.println("tienes "+ moneda5 + " monedas de $500 lo que equivale a: $" + (moneda5*500));
                            break;

                    }
                    break;
                case 3:
                    System.out.println("tu dinero actul es: "+ (moneda1*20 + moneda2*50 + moneda3*100 + moneda4*200 + moneda5*500));
                    break;
                case 4:
                    moneda1=0;
                    moneda2=0;
                    moneda3 = 0;
                    moneda4 =0;
                    moneda5 =0;
                    System.out.println("tu dinero actul es: "+ (moneda1*20 + moneda2*50 + moneda3*100 + moneda4*200 + moneda5*500));
                    break;

                default:
                    System.out.println("opcion no valida");
                    break;
            }

        }while(opcion!=5);
        System.out.println("adios");
    }
}