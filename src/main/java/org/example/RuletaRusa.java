package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {


    List<Integer> tambor = new ArrayList<>();
    Random ra =new Random();
    private int bala;
    private  int posicionActual;


    public RuletaRusa() {
        for (int i=0;i < 6;i++){
            tambor.add(i);
        }

        bala= ra.nextInt(6)+1;
        posicionActual= 1;
    }

    public boolean disparar(){
        boolean a;
        if (this.bala == this.posicionActual){
            a = true;

        }else{
            a= false;
            this.posicionActual ++;
        }
        return a;
    }

    public void reiniciarJuego (){
        tambor.clear();
        this.bala=ra.nextInt(6)+1;
        this.posicionActual=1;

    }

    @Override
    public String toString() {
        return "RuletaRusa{" +
                "bala=" + bala +
                ", posicionActual=" + posicionActual +
                '}';
    }
}
