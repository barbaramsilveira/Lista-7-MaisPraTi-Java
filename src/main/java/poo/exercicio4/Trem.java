package poo.exercicio4;

import poo.exercicio4.IMeioTransporte;

public class Trem implements IMeioTransporte {
    private int velocidade;
    private final int velocidadeMaxima;

    public Trem() {
        this.velocidade = 0;
        this.velocidadeMaxima = 220;
    }
    @Override
    public void acelerar() {
        if (this.velocidade < this.velocidadeMaxima) {

            this.velocidade += 20;
            System.out.println("Velocidade do Trem após acelerar: " + this.velocidade);
        } else {
            throw new IllegalArgumentException("Velocidade do Trem acima do permitido!");
        }
    }

    @Override
    public void frear() {
        if(this.velocidade > 0 ){
            this.velocidade -= 20;
            System.out.println("Velocidade do Trem após frear: " + this.velocidade);
        }
    }
    @Override
    public int getVelocidade() {
        return velocidade;
    }
}
