package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {

    private List<Integer> tambor = new ArrayList<>();
    private Random ra = new Random();
    private int posicionActual;

    public RuletaRusa() {
        for (int i = 0; i < 6; i++) {
            tambor.add(0);
        }
        int posicionBala = ra.nextInt(6);
        tambor.set(posicionBala, 1);
        posicionActual = 0;
    }

    public boolean disparar() {
        boolean disparoFatal = (tambor.get(posicionActual) == 1);
        avanzarTambor();
        return disparoFatal;
    }

    private void avanzarTambor() {
        posicionActual++;
        if (posicionActual >= tambor.size()) {
            posicionActual = 0;
        }
    }

    public void reiniciarJuego() {
        tambor.clear();
        for (int i = 0; i < 6; i++) {
            tambor.add(0);
        }
        int posicionBala = ra.nextInt(6);
        tambor.set(posicionBala, 1);
        posicionActual = 0;
    }

    @Override
    public String toString() {
        int posicionBala = tambor.indexOf(1) + 1;
        String cuadro = "\u001B[35m";
        String letras = "\u001B[32m";
        String valores = "\u001B[31m";
        String primer= cuadro+"|-----|---------|\n|";
        String segundo= letras+"bala "+cuadro+"|"+letras+" posicion"+cuadro+"|";
        String tercer = "\n|-----|---------|\n|  ";
        String cuarto = valores+posicionBala+cuadro+"  |    "+valores+ posicionActual+cuadro+"    |" ;
        String quinto = cuadro+"\n|-----|---------|\u001B[0m";

        return primer+segundo+tercer+ cuarto+quinto;
    }
}
