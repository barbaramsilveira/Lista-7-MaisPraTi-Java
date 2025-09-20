package poo.exercicio4;

public class Bicicleta implements IMeioTransporte {
    private int velocidade;
    private final int velocidadeMaxima;

    public Bicicleta() {
        this.velocidade = 0;
        this.velocidadeMaxima = 40;
    }
    @Override
    public void acelerar() {
        if (this.velocidade < this.velocidadeMaxima) {

            this.velocidade += 5;
            System.out.println("Velocidade da Bicicleta após acelerar: " + this.velocidade);
        } else {
            throw new IllegalArgumentException("Velocidade da Bicicleta acima do permitido!");
        }
    }

    @Override
    public void frear() {
        if(this.velocidade > 0 ){
            this.velocidade -= 5;
            System.out.println("Velocidade da Bicicleta após frear: " + this.velocidade);
        }
    }
    @Override
    public int getVelocidade() {
        return velocidade;
    }
}


