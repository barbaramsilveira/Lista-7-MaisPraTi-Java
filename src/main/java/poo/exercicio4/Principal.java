package poo.exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<IMeioTransporte> transportes = new ArrayList<>();
        transportes.add(new Carro());
        transportes.add(new Bicicleta());
        transportes.add(new Trem());

        for (IMeioTransporte t : transportes) {
            try {
                t.acelerar();
                t.frear();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        for (IMeioTransporte t : transportes) {
            String tipo = t.getClass().getSimpleName();
            System.out.println(tipo + ": " + t.getVelocidade() + " km/h");
        }
    }
}
